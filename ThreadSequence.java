package SapientTest;

public class ThreadSequence extends Thread {

	int i =0;
	public void run() {
		while(i<2) {
			System.out.println(i);
			i++;
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        ThreadSequence ts1=new ThreadSequence();
        ThreadSequence ts2=new ThreadSequence();
        ThreadSequence ts3=new ThreadSequence();
        ts1.start();
        ts1.join();
        ts2.start();
        ts2.join();
        ts3.start();
        ts3.join();
        
	}

}
