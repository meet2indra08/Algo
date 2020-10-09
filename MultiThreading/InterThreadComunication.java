package SapientTest.MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*every object in java has only one lock or monitor and wait(),notify(),notifyAll() are used for monitor sharing   
that why that why this is part of object class rathr than thread class. This methods work on locks and locks are associated with 
Object not thread that is the reason all three are in object class.*/

/*/* For sharing the singlnals threads shold have gaurntee the update so that it should be within synchronize block. and lock is required 
 * when calling wait() method.*/

class Producer extends Thread {
	BlockingQueue queue;

	Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void produced() {
		synchronized (queue) {
			if (queue.size() == 1) {
				System.out.println("Producer stop producing data into the queue");
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				queue.put("indra");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			queue.notify();

		}
	}

}

class Consumer 
{
	BlockingQueue queue;
	
	Consumer(BlockingQueue queue)
	{
		this.queue=queue;
	}
	
	public void consume() throws InterruptedException {
		synchronized (queue) {
			if(queue.size()==0)
			{
				queue.wait();
			}
			
		}
		String a =(String) queue.take();
		System.out.println("Quue Data"+a);
		//queue.notifyAll();
	}
	
	
}

public class InterThreadComunication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BlockingQueue queue=new ArrayBlockingQueue(1);
		Producer producer= new Producer(queue);
		Consumer consumer= new Consumer(queue);
		
		
		Thread thread1= new Thread(()->producer.produced());
		Thread thread2= new Thread(()-> {
			try {
				consumer.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		thread1.start();
		thread2.start();

	}

}
