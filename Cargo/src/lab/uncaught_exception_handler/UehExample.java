package lab.uncaught_exception_handler;

public class UehExample {

	public UehExample() {
		// TODO Auto-generated constructor stub
	}

   public static void main(String[] args) {

		  Thread t = new Thread(new AdminThread());
		  t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			 public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t + " throws exception: " + e);
			 }
		  });
		  // this will call run() function
		  t.start();
   }
   
}

class AdminThread implements Runnable {
	   public void run() {
	      throw new RuntimeException();
	   }
} 
