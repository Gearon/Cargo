package lab.wait_notify_notifyall;

public class Main {
	private static Object locker = new Object();

	public static void main(String args[]){
		Main main = new Main();
		String name1 = "worker1";
		String name2 = "worker2";
		String name3 = "worker3";
		Worker worker1 = main.new Worker(name1);
		worker1.start();
		Worker worker2 = main.new Worker(name2);
		worker2.start();
		Worker worker3 = main.new Worker(name3);
		worker3.start();
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		synchronized(locker){
			locker.notify();
		}
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		synchronized(locker){
			locker.notify();
		}
		
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		synchronized(locker){
			locker.notify();
		}
	}
	
	class Worker extends Thread{
		
		public Worker(String name){
			this.setName(name);
		}

		@Override
		public void run(){
			System.out.println(this.getName() + " is waiting...");
			synchronized(locker){
				try {
					locker.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(this.getName() + " is finished...");
		}
	}
}

