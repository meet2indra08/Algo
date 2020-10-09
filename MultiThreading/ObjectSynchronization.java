package SapientTest.MultiThreading;

class SynchonizeExchanger
{
	protected Object object;

	public synchronized Object getObject() {
		return object;
	}

	public synchronized void setObject(Object object) {
		this.object = object;
	}
	
	/*
	 * public Object getObject() {
	 * 
	 * synchronized (this) { return object; } }
	 * 
	 * public void setObject(Object object) { //This is monitor object and one
	 * thread this is same as above instance lavel locking on same object with two
	 * thread synchronized (this) { this.object = object; }
	 * 
	 * }
	 */
	
	
}

public class ObjectSynchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  SynchonizeExchanger synchonizeExchanger= new SynchonizeExchanger();
	  Thread thread1= new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<1000;i++)
			{
				synchronized (this) {
					synchonizeExchanger.setObject(""+i);	
				}
				
			}
		};
	});
	  
	  Thread thread2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++)
				{
					synchronized (this) {
						System.out.println(synchonizeExchanger.getObject());	
					}
					
				}
			};
		});
	  thread1.start();
	  thread2.start();
	}
	
//Thread get object sometime execute before set thread so result varry 			  
//If a synchronized method is locked by a thread can call other synchronize method.
//There is only one thread enter into sysnchornized block 
//There is no gurantee of sequence in which waiting thread get access 
	

}
