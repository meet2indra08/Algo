package SapientTest.MultiThreading;

class SynchonizeExchanger1
{
	protected static Object object;

	public static synchronized Object getObject() {
		return object;
	}

	public static synchronized void setObject(Object object) {
		object = object;
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

public class ClassSynchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	  SynchonizeExchanger synchonizeExchanger= new SynchonizeExchanger();
	  Thread thread1= new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<1000;i++)
			{
				synchronized(SynchonizeExchanger1.class) {
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
					synchronized (SynchonizeExchanger1.class) {
						System.out.println(synchonizeExchanger.getObject());	
					}
					
				}
			};
		});
	  thread1.start();
	  thread2.start();
	}
	
//Thread get object sometime execute before set thread so result varry 			  
//If Monitor obejct is null it will throw null pointer exception
	

}
