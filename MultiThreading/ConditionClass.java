package SapientTest.MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ConditionSingnal
{
	BlockingQueue queue;
	private Lock lock=new ReentrantLock();
	private Condition added=lock.newCondition();
	private Condition removed= lock.newCondition();
	
	ConditionSingnal(BlockingQueue queue)
	{
		this.queue=queue;
	}
	
	public void producer() throws InterruptedException
	{
		lock.lock();
		try {
		if(queue.size()==10)
			removed.await();
		 queue.add("My name");
		 added.signalAll();
		}finally {
			lock.unlock();
		}
	}
	public void consumer() throws InterruptedException
	{
		lock.lock();
		try {
			if(queue.size()==0)
				added.await();
			System.out.println(queue.take());
			removed.signalAll();
		}finally {
			lock.unlock();
		}
	}
	
	
	
}


public class ConditionClass {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConditionSingnal conditionSingnal= new ConditionSingnal(new ArrayBlockingQueue(10));	
Thread thread = new Thread(()-> {
	try {
		conditionSingnal.producer();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
});

Thread thread2 = new Thread(()-> {
	try {
		conditionSingnal.consumer();;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
});
thread.start();
thread2.start();
thread.interrupt();
}
}