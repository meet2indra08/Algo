package SapientTest.MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {

	public void doSomething(){
		//do some operation, DB read, write etc
	}
	
	public void doLogging(){
		//logging, no need for thread safety
	}
}



class ConcurrencyLockExample implements Runnable{

	private Resource resource;
	private Lock lock;
	
	public ConcurrencyLockExample(Resource r){
		this.resource = r;
		this.lock = new ReentrantLock();
	}
	
	@Override
	public void run() {
		try {
			if(lock.tryLock(10, TimeUnit.SECONDS)){
			resource.doSomething();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//release lock
			lock.unlock();
		}
		resource.doLogging();
	}

}
 

class SynchronizedLockExample implements Runnable{

	private Resource resource;
	
	public SynchronizedLockExample(Resource r){
		this.resource = r;
	}
	
	@Override
	public void run() {
		synchronized (resource) {
			resource.doSomething();
		}
		resource.doLogging();
	}
}
public class ReentrantLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}


/*
What are Reentrant Locks?

The ReentrantLock class implements the Lock interface and provides synchronization to methods while accessing shared resources.
 The code which manipulates the shared resource is surrounded by calls to lock and unlock method. 
 This gives a lock to the current working thread and blocks all other threads 
 which are trying to take a lock on the shared resource.

*/