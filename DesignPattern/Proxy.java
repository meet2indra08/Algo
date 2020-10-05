package SapientTest.DesignPattern;

import java.io.IOException;

interface CommandExecutor 
{
	public void executeCommand(String cmd);
	
}

class CommandExecutorImpl implements CommandExecutor
{

	@Override
	public void executeCommand(String cmd) {
		// TODO Auto-generated method stub
	try {
		Runtime.getRuntime().exec(cmd);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}

class CommandexecutorProxy implements CommandExecutor
{

	//check user is admin
	
	@Override
	public void executeCommand(String cmd) {
		// TODO Auto-generated method stub
		//if(//user admin)
				//executeCommand(cmd);
		
			//	else {
				//	throw Ec
				//}
	}
	
}

public class Proxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
