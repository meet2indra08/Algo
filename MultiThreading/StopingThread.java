package SapientTest.MultiThreading;

public class StopingThread {
	

	public static class StopableRubbable implements Runnable
	{
		public boolean stoprequest=false;
		
		public synchronized void stopRequest()
		{
			this.stoprequest=true;
		}
		
		public synchronized boolean isStopRequested()
		{
			return this.stoprequest;
		}
		
		private void sleep(long milisec) throws InterruptedException
		{
			Thread.sleep(10000);
		}
		
		@Override
		public void run() {
			System.out.println("Stopable running ");
			while(!isStopRequested())
			{
				System.out.println("My ownthread ");
				try {
					sleep(1000000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// TODO Auto-generated method stub
			System.out.println("Stopable stop ");
			
		}
		
	}
	public static void main(String[] args) {
		
		StopableRubbable stopableRubbable=new  StopableRubbable();
		Thread thread=new Thread(stopableRubbable);
		thread.start();
		stopableRubbable.stopRequest();
		
	}

}
