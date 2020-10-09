package SapientTest.MultiThreading;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * Ritant lock acquired lock on it and all rest witing thread are in the queue but in ReadWrite Lock w can have more than one thread
 * can read the data abd take lock for read but only one thread can write data into it
 * 
 * One Writer At a time or multiple reader at a time
 */




public class ReadWriteLockTest {

	
	public static class ReadWriteResouce{
	
		private ReentrantReadWriteLock lock= new ReentrantReadWriteLock();
		private ReentrantReadWriteLock.ReadLock readLock=lock.readLock();
		private ReentrantReadWriteLock.WriteLock writeLock=lock.writeLock();
		
		public void readResource()
		{
			readLock.lock();
			System.out.println(Thread.currentThread().getName()+"Start reading");
			//Read the resource 
			readLock.unlock();
		}
		
		public void writeResource()
		{
			writeLock.lock();
			System.out.println(Thread.currentThread().getName()+"Writing into resource or file");
			//Read the resource 
			writeLock.unlock();
		}
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AtomicBoolean atomicBoolean=new AtomicBoolean();
		
		ReadWriteResouce resource= new ReadWriteResouce();
		
		Thread thread=new Thread(()-> resource.readResource());
		Thread thread1=new Thread(()-> resource.readResource());
		Thread thread2=new Thread(()-> resource.writeResource());
	    Thread thread3=new Thread(()-> resource.writeResource());
	    thread.start();
	    thread1.start();
	    thread2.start();
	    thread3.start();
	    
	}

}
