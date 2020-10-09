package SapientTest.MultiThreading;

import java.util.concurrent.Semaphore;

/*
 * This is counter permits example if we want only three request or thread can access the service at a time than we use semaohore
 * once any thread release the than other thread enter it=nto service to access
 */
public class SemaphoreTest {
	
	public static class task implements Runnable
	{
     
		Semaphore semaphore= new Semaphore(2);
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
