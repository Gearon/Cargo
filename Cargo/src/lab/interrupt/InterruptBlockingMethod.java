package lab.interrupt;

/**
 * The sleep method in Thread is blocking method. The interrupt exception will be thrown when interrupt it
 *
 */
public class InterruptBlockingMethod {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		try{
			Worker worker = new Worker();
			worker.start();
			Thread.sleep(5000);
			Interruptor interruptor = new Interruptor(worker);
			interruptor.start();
		}catch(Exception e){
			System.out.println("The main method threw exception...");
		}
	}
}

	class Worker extends Thread{

		@Override
		public void run(){
			while(true){
				try{
					System.out.println("Worker is working...");
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	class Interruptor extends Thread{

		Thread worker;
		
		public Interruptor(Worker worker) {
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
