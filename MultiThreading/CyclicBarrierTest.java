package SapientTest.MultiThreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	public static class Task implements Runnable 
	{
      CyclicBarrier barrier;
      Task(CyclicBarrier barrier){
    	  this.barrier=barrier;
      }
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Send message");
		}
		}
		
		//
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService service= Executors.newFixedThreadPool(10);
		CyclicBarrier barrier= new CyclicBarrier(3);
		service.execute(new Task(barrier));
		service.execute(new Task(barrier));
		service.execute(new Task(barrier));

	}

}
