package SapientTest.MultiThreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
	
	public static class DependentService implements Runnable
	{
       CountDownLatch latch;
       DependentService(CountDownLatch latch){
    	   this.latch=latch;}
              
		@Override
		public void run() {
			// Startup Task Like DB service Start
			System.out.println("DB Service load data");
			latch.countDown();
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService service= Executors.newFixedThreadPool(3);
		CountDownLatch latch= new CountDownLatch(3);
		service.execute(new DependentService(latch));
		service.execute(new DependentService(latch));
		service.execute(new DependentService(latch));
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All dependent service initialize");

	}

}
