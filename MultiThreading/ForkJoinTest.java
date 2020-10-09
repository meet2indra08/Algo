package SapientTest.MultiThreading;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/*
 * This is same as executer service framework but the differentces is in Executor service threads are stored in Blocking queue
 * or some other datastructure for a task. But in Fork join framework Task producing substask and subtask can also produce subtask
 * and finally it will join result of all subtask and return result .  
 * 
 * Lets see bleo Example of fabonacii series 
 */


class Fabonacii extends RecursiveTask<Integer> 
{
	final int n;
	Fabonacii(int n){this.n=n;}

	@Override
	protected Integer compute() {
		if(n<=1)
		return n;
		//For fabonacii we have two task adding of prevous two number 
		Fabonacii f1= new Fabonacii(n-1);
		f1.fork();
		Fabonacii f2= new Fabonacii(n-2);
		f1.fork();
		return f1.join()+f2.join();
	}
	
}

public class ForkJoinTest {
  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fabonacii foFabonacii = new Fabonacii(10);
		ForkJoinPool forkJoinPool= new ForkJoinPool();
		//List<ForkJoinTask> res=new ArrayList<ForkJoinTask>();
		ForkJoinTask<Integer> i=  forkJoinPool.submit(foFabonacii);
		System.out.println(i);
		

	}

}
