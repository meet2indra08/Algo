package SapientTest;

import java.util.Date;

class Address1
{
	String flatno;
	String StreetName;
	public Address1() {
		// TODO Auto-generated constructor stub
	}
	Address1(String name,String streatName){
		this.flatno=name;
		this.StreetName=streatName;
	}
	public String getFlatno() {
		return flatno;
	}
	public void setFlatno(String flatno) {
		this.flatno = flatno;
	}
	public String getStreetName() {
		return StreetName;
	}
	public void setStreetName(String streetName) {
		StreetName = streetName;
	}
	
}


public class CloneEmployee implements Cloneable {	
	
	private String name;
	private double salary;
	private Date hireDay;
	private Address1 address;
	
	CloneEmployee(String name, double salary,Date hireDate,Address1 address)
	{
		this.name=name;
		this.salary=salary;
		this.hireDay=new Date(hireDate.getDate());
		Address1 address1=new Address1();
		address1.setFlatno(address.getFlatno());
		address1.setStreetName(address.getStreetName());
		this.address=address1;
	}
	
	public CloneEmployee clone() throws CloneNotSupportedException
	{
		CloneEmployee obj=(CloneEmployee)super.clone();
		Date hireDate=new Date(this.hireDay.getDate());
		Address1 address1=new Address1();
		address1.setFlatno(this.address.getFlatno());
		address1.setStreetName(this.address.getStreetName());
		obj.setHireDay(hireDate);
		obj.setAddress(address1);
		return obj;
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	public Address1 getAddress() {
		return address;
	}

	public void setAddress(Address1 address) {
		this.address = address;
	}
	
	
	
	

}
