package lab.interrupt;

public class InterruptGettingIntrinsicLock {

	public static void main(String args[]){
		try{
			Worker2 worker = new Worker2();
			worker.start();
			Thread.sleep(5000);
			Interruptor2 interruptor = new Interruptor2(worker);
			interruptor.start();
		}catch(Exception e){
			System.out.println("The main method throw exception...");
		}
	}
}

class Worker2 extends Thread{

	@Override
	public void run(){
		while(true){
			try{
				synchronized(this){
					this.wait();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

class Interruptor2 extends Thread{

	Thread worker;
	
	public Interruptor2(Worker2 worker) {
		// TODO Auto-generated constructor stub
		this.worker = worker;
	}

	@Override
	public void run(){
		System.out.println("isInterrupted before: " + worker.isInterrupted());
		worker.interrupt();
		System.out.println("isInterrupted after: " + worker.isInterrupted());
	}
}

