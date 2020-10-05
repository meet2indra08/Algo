package SapientTest.DesignPattern;

abstract class MyComputer {
   
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();
     
}

class PC extends MyComputer {
	 
    private String ram;
    private String hdd;
    private String cpu;
     
    public PC(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }
 
    @Override
    public String getHDD() {
        return this.hdd;
    }
 
    @Override
    public String getCPU() {
        return this.cpu;
    }
 
}

class Server extends MyComputer {
	 
    private String ram;
    private String hdd;
    private String cpu;
     
    public Server(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }
 
    @Override
    public String getHDD() {
        return this.hdd;
    }
 
    @Override
    public String getCPU() {
        return this.cpu;
    }
 
}

//First of all we need to create a Abstract Factory interface or abstract class.
interface ComputerAbstractFactory {
	public MyComputer createComputer();
}

class PCFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;
	
	/*
	 * public PCFactory(String ram, String hdd, String cpu){ this.ram=ram;
	 * this.hdd=hdd; this.cpu=cpu; }
	 */
	@Override
	public MyComputer createComputer() {
		return new PC(ram,hdd,cpu);
	}

	
}

class ServerFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;
	
	public ServerFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	@Override
	public MyComputer createComputer() {
		return new Server(ram,hdd,cpu);
	}

}

class ComputerFactory {

	public static MyComputer getComputer(ComputerAbstractFactory factory){
		return factory.createComputer();
	}
}





public class AbstractFactoryImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			MyComputer pc = ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
			MyComputer server = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
			System.out.println("AbstractFactory PC Config::"+pc);
			System.out.println("AbstractFactory Server Config::"+server);
		

	}

}
