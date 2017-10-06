package lab.volatile_variable;

/**
 * 
 * If the variable x and y are not declared volatile, 
 * the program may output 0. 
 * A nice explanation is from: https://stackoverflow.com/a/16629365/3378204
 */
public class VolatileExample {

	public VolatileExample() {
		// TODO Auto-generated constructor stub
	}
	
	static int x;
	static int y;
	
	static class T1 extends Thread{
		@Override
		public void run(){
			x = 1;
			y = 10;
		}
	}
	
	static class T2 extends Thread{

		@Override
		public void run(){
			if(y == 10){
				System.out.println(x);
			}
		}
	}

	public static void main(String args[]){
		T1 t1 = new T1();
		T2 t2 = new T2();
		t1.start();
		t2.start();
	}
}
