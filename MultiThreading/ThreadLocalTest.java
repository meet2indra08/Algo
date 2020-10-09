package SapientTest.MultiThreading;

import java.time.LocalDate;

/*
 * Support you have 1000 of task like run method that need to run for date creation and updation and date is not threadsafe
 * In that case per task 1 date object created. To avoid this poblem we need to create a gloable threadlocal date that 
 * all thread use that variable as seprate copy.
 * 
 * Anothe note that if we have 1000 of task like run() than we need not to crate thread or every task.
 * To avoid this problem we can create a threadpool for the same using Executor Service
 * 
 * One more example If we have a requst on service one and service 1 get userdeatil  and call other servce like service 2 , service 3 
 * so on, if service 2 ,3 required user detail than we need to create map for that but if we user Threadlocal as cobtext is accesseble 
 * cross all request service of thread 1 on service 1.
 * 
 * Threadloacl is contectholder there are many Thrasaction ContextHolder,LocalecontectHolder, Requestcontectholder
 * are used threadlocal to create context in springS
 */

public class ThreadLocalTest {
	
	public static LocalDate localDate = LocalDate.now();

	public static ThreadLocal<LocalDate> todaydate=ThreadLocal.withInitial(()-> LocalDate.now());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
	//task 
		Thread t1= new Thread(()->localDate.get(null));
		
		
	}

}
