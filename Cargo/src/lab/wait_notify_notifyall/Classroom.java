package lab.wait_notify_notifyall;

/**
 * The object.wait() will break current thread and it will return only after object.notifyAll()
 * is called or object.notify() is called and the thread is waked fortunately.
 * Note:
 * To invoke an object's wait(), notify() or notifyAll() method, must obtain the object's 
 * intrinsic lock firstly or IllegalMonitorStateException will throw.
 * When object's wait() is called, the intrinsic lock will be released.
 */
public class Classroom {

	public Classroom() {
		// TODO Auto-generated constructor stub
	}

	static class Student implements Runnable {
		int id;
		Object lock;

		public Student(int id, Object lock) {
			this.id = id;
			this.lock = lock;
		}

		public void run() {
			takeClass();
		}

		public void takeClass() {
			synchronized (lock) {
				try {
					System.out.format("Student%d is ready for class...%n", id);
					lock.wait();
					System.out.format("Student%d gets out of the classroom%n", id);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static class Teacher implements Runnable {

		Object lock;

		public Teacher(Object lock) {
			this.lock = lock;
		}

		public void run() {
			teach();
		}

		public void teach() {
			synchronized (lock) {
				System.out.format("The teacher is teaching...%n");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.format("The teacher finish his ppt...%n");
				lock.notifyAll();
			}
		}
	}

	public static void main(String args[]) {
		Object lock = new Object();

		for (int i = 0; i < 10; i++) {
			new Thread(new Student(i, lock)).start();
		}
		/*
		 * Thread sleep 3000 milliseconds to avoid teacher getting the intrinsic
		 * lock before any student
		 */
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new Teacher(lock)).start();

	}

}
