package SapientTest.MultiThreading;

//Crtical path is race conditio where critical code shared and may leads incorrect results 
//Race condition only occur when multiple threads update shared resources
class MyRunnable implements Runnable {

	//This is share reqource i we can create one runnble passing to thread
	protected int count = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			synchronized (this) { //Race condition should always be in synchronized block or volatile or AutomicVariables 
				this.count++;	
			}
			
		}
		System.out.println(Thread.currentThread().getName()+" "+"count"+count);

	}

}

public class RaceCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable myRunnable=new MyRunnable();
		Thread thread1=new Thread(myRunnable,"Thread1");
		Thread thread2=new Thread(myRunnable,"Thread2");
		//Here in above same runabble object is pointing to count so it is share resource 
		thread1.start();
		thread2.start();
		//Count will be different So this is race condition 
		
        //Lets create two Runable object and see count is not shared resource now 
		/*
		 * MyRunnable myRunnable3=new MyRunnable(); MyRunnable myRunnable4=new
		 * MyRunnable(); Thread thread3=new Thread(myRunnable3,"Thread3"); Thread
		 * thread4=new Thread(myRunnable4,"Thread4"); thread3.start(); thread4.start();
		 */

	}

}
