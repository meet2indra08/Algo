package SapientTest.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Future is a placevariable for avalue that may arrive near future
 * 
 */

public class FutureCallable {

	public static class Task implements Callable<Integer>
	{

		@Override
		public Integer call() throws Exception {
			// TODO Auto-generated method stub
			return new Random().nextInt();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService futureservice= Executors.newFixedThreadPool(10);
		List<Future> allFuture= new ArrayList<>();
		
		for(int i=0;i<100;i++)
		{
			Future<Integer> result=futureservice.submit(new Task());
			allFuture.add(result);
			
		}
		for (Future future : allFuture) {
			System.out.println(future.get());
		}
		
		}

}
