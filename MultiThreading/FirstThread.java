package SapientTest.MultiThreading;

public class FirstThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Blank Thread
		Thread t=new Thread();
		t.start();
		System.out.println("Just finished");
		//Annonymus 
		Thread t2= new Thread() {
			public void run() {
				System.out.println("Anaonumus Thread");
			}
		};
        t2.start();
        //Lamda
        Runnable runaRunnable=()->{System.out.println("This is my runnable thread");};
		Thread lamdarunnable=new Thread(runaRunnable);
		lamdarunnable.start();
		
		
		//Pausing Thread
		Thread thread=new Thread() {
			public void run()
			{
				System.out.println("start pausing through sleep static method of thread");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread is active"+Thread.currentThread().getName());
				
			}
			
		};
		thread.start();
	}}
		
