package SapientTest.MultiThreading;

import java.awt.SecondaryLoop;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * Executer service is used in case if we have 1000 of task and for 1000 of task we need to create 1000 of thraed
 * that is expensive in java so that we use Threadpool for already created thread and we can subit the tsk
 * into threadpool and it will pickup the task and execute
 * 
 * Internally threadpool using blocking queueu that is threadsafe it pull data from blocking queue
 * FixedThreadPool is using blocking queue
 * CacheThreadPool using sechronized queue 
 * ScheduledThreadPool will schedule job ScheduleatFixedrate,scheduleWithFixedDelay and schdule 
 * newSingleThreadExecutor is used to ensure one thread execute beore other
 * 
 *  Internally every executor menotod is using ThreadPoolExecutor as constructor and  it accesspt list of parameter lile Factory that will
 *  create thread automatically and blocking queue, senchronizedqueue etc.
 */ 

//Old problem
/*class Task implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("My task print");
	}
	for(int i; i<1000;i++)
	{
		Thread thread= New Thread(new Task());
	}
	
}*/

public class ExecuterServiceTest {
	
	static class Task implements Runnable{
		public void run() {
		System.out.println(Thread.currentThread().getName());	
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ExecutorService service= Executors.newFixedThreadPool(2);
		ExecutorService service= Executors.newCachedThreadPool();
		//submit task
		for(int i=0;i<100;i++)
		{
			//service.submit(new Task());
			service.execute(new Task());
			
		}
		
		//This is case of Scheduled Thread Pool
		ScheduledExecutorService schexecutorService=Executors.newScheduledThreadPool(10);
		TimeUnit SECONDS = null;
		//Return After 10 second deplay
	    schexecutorService.schedule(new Task(), 10, SECONDS);
	  //Task run repetively every 10 second
	    schexecutorService.scheduleAtFixedRate(new Task(), 15, 10, SECONDS);
	    //Task to repete 10 second after previous task completed 
	    schexecutorService.scheduleWithFixedDelay(new Task(), 15, 10, SECONDS);
	    
	    //this will ensure thread 1 should execute before than 2
	    ExecutorService service2=Executors.newSingleThreadExecutor();
	    service2.execute(new Task());
	    
	    
	
		System.out.println(Thread.currentThread().getName());
		
		

	}

}
