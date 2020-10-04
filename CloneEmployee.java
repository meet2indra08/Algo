package SapientTest;

import java.util.Date;

public class CloneEmployee implements Cloneable {	
	
	private String name;
	private double salary;
	private Date hireDay;
	
	CloneEmployee(String name, double salary)
	{
		this.name=name;
		this.salary=salary;
		this.hireDay=new Date();
	}
	
	public CloneEmployee clone() throws CloneNotSupportedException
	{
		CloneEmployee obj=(CloneEmployee)super.clone();
		obj.hireDay=(Date)hireDay.clone();
		return obj;
		
		
	}
	
	
	
	

}
