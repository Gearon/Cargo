package lab.semaphore;

import java.util.concurrent.Semaphore;

public class SemephoreExample {

	public SemephoreExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]){
		Semaphore semaphore = new Semaphore(3);
		for(int i = 0; i < 5; i++){
			try{
				new Thread(new Customer(semaphore)).start();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

class Customer implements Runnable{
	
		Semaphore semaphore;
		
		public Customer(Semaphore semaphore){
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				semaphore.acquire();
				System.out.println(Thread.currentThread().getName() + " get services...");
				Thread.sleep(5000);
				semaphore.release();
				System.out.println(Thread.currentThread().getName() + " leaves");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
