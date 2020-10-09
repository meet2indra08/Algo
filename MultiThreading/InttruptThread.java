package SapientTest.MultiThreading;

public class InttruptThread {
public static class Task implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		for(int i=0;i<10000;i++)
		{
			System.out.println("count ::"+i);
			if(Thread.currentThread().isInterrupted())
			{
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.interrupted();
			}
		}
		
	}
	
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method st
		Thread thread= new Thread(new Task());
		thread.start();
		thread.interrupt();
		
		
		
	}

}
