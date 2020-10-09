package SapientTest.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedExecutorTest {

	static class Task implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<2;i++)
			{
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
			
		}
		
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service= Executors.newSingleThreadExecutor();
		service.execute(new Task());
		service.execute(new Task());
		service.execute(new Task());
		

	}

}
