package lab.interrupt;

/**
 *	There is no blocking method in worker thread. No interrupt exception will be thrown.
 *  However, the interrupt status will be set to true when the worker thread's interrupt method is called.
 *  The status can be checked inside the worker thread to terminate gracefully 
 */
public class InterruptNormalMethod {

	public static void main(String args[]){
		try{
			Worker1 worker = new Worker1();
			worker.start();
			Thread.sleep(5000);
			Interruptor1 interruptor = new Interruptor1(worker);
			interruptor.start();
		}catch(Exception e){
			System.out.println("The main method threw exception...");
		}
	}
}

class Worker1 extends Thread{

	@Override
	public void run(){
		while(true){
			try{
				for(int i = 0; i < 1000000; i++){
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

class Interruptor1 extends Thread{

	Thread worker;
	
	public Interruptor1(Worker1 worker) {
		// TODO Auto-generated constructor stub
		this.worker = worker;
	}

	@Override
	public void run(){
		System.out.println("Before: " + worker.isInterrupted());
		worker.interrupt();
		System.out.println("After: " + worker.isInterrupted());
	}
}

