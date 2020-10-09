package SapientTest.MultiThreading;
//Java program to illustrate Deadlock 
//in multithreading. 
class Util 
{ 
    // Util class to sleep a thread 
    static void sleep(long millis) 
    { 
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
} 

//This class is shared by both threads 
class Shared {
	// first synchronized method
	synchronized void test1(Shared s2) {
		System.out.println("test1-begin");
		Util.sleep(1000);

		// taking object lock of s2 enters
		// into test2 method
		s2.test2();
		System.out.println("test1-end");
	}

	// second synchronized method
	synchronized void test2() {
		System.out.println("test2-begin");
		Util.sleep(1000);
		// taking object lock of s1 enters
		// into test1 method
		System.out.println("test2-end");
	}
}

class Thread1 extends Thread 
{ 
    private Shared s1; 
    private Shared s2; 
  
    // constructor to initialize fields 
    public Thread1(Shared s1, Shared s2) 
    { 
        this.s1 = s1; 
        this.s2 = s2; 
    } 
  
    // run method to start a thread 
    @Override
    public void run() 
    { 
        // taking object lock of s1 enters 
        // into test1 method 
        s1.test1(s2); 
    } 
}

class Thread2 extends Thread 
{ 
    private Shared s1; 
    private Shared s2; 
  
    // constructor to initialize fields 
    public Thread2(Shared s1, Shared s2) 
    { 
        this.s1 = s1; 
        this.s2 = s2; 
    } 
  
    // run method to start a thread 
    @Override
    public void run() 
    { 
        // taking object lock of s2 
        // enters into test2 method 
        s2.test1(s1); 
    } 
} 


  
public class Deadlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // creating one object 
        Shared s1 = new Shared(); 
  
        // creating second object 
        Shared s2 = new Shared(); 
  
        // creating first thread and starting it 
        Thread1 t1 = new Thread1(s1, s2); 
        t1.start(); 
  
        // creating second thread and starting it 
        Thread2 t2 = new Thread2(s1, s2); 
        t2.start(); 
  
        // sleeping main thread 
        Util.sleep(2000); 

	}

}

/*
 * Avoid Dead Lock condition

We can avoid dead lock condition by knowing its possibilities. It’s a very complex process and not easy to catch. 
But still if we try, we can avoid this. There are some methods by which we can avoid this condition. 
We can’t completely remove its possibility but we can reduce.

Avoid Nested Locks : This is the main reason for dead lock. Dead Lock mainly happens when we give locks to multiple threads.
Avoid giving lock to multiple threads if we already have given to one.
Avoid Unnecessary Locks : We should have lock only those members which are required.
Having lock on unnecessarily can lead to dead lock.
Using thread join : Dead lock condition appears when one thread is waiting other to finish. 
If this condition occurs we can use Thread.join with maximum time you think the execution will take.
Important Points :
If threads are waiting for each other to finish, then the condition is known as Deadlock.
Deadlock condition is a complex condition which occurs only in case of multiple threads.
Deadlock condition can break our code at run time and can destroy business logic.
We should avoid this condition as much as we can.
 * 
 */

/*
 * Lock Ordering
Lock Timeout
Deadlock Detection
*/
 
/*Avoid a loack using new lock macahnisam
 * 
 * trylock for a spcific time and time out
 * 
 * */



