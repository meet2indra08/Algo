package SapientTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import com.sun.org.apache.bcel.internal.generic.IMUL;

class Address
{
	String flatno;
	String StreetName;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	Address(String name,String streatName){
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

final class ImmutableClass {

	private final int id;
	private final String name;
	//Mutable Object
	private final Date date;
	private final Address address;
	ImmutableClass(int id,String name,Date date,Address address){
		this.id=id;
		this.name=name;
		this.date=new Date(date.getTime());
		Address address2=new Address();
		address2.setFlatno(address.getFlatno());
		address2.setStreetName(address.getStreetName());
		this.address=address2;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Date getDate()
	{
		return new Date(date.getTime());
	}
	
	public Address getAddress()
	{
		Address address2=new Address();
		address2.setFlatno(this.address.getFlatno());
		address2.setStreetName(this.address.getStreetName());
		return address2;
	}
	public static void main(String[] srgs) {
		Address address=new Address("1","Streat2");
		ImmutableClass immutableClass = new ImmutableClass(1, "Indra", new Date(),address);
		System.out.println("*****Before Editing**********");
		System.out.println("Id  :"+immutableClass.getId());
		System.out.println("Name :"+immutableClass.getName());
		System.out.println("Date :"+immutableClass.getDate());
		System.out.println("Address streat::"+immutableClass.getAddress().getFlatno());
		System.out.println("Address streat::"+immutableClass.getAddress().getStreetName());
		immutableClass.getAddress().setFlatno("3");
		immutableClass.getAddress().setStreetName("Streat3");
		System.out.println("*****After Editing**********");
		System.out.println("Address streat::"+immutableClass.getAddress().getFlatno());
		System.out.println("Address streat::"+immutableClass.getAddress().getStreetName());
		
	}
	
	
	

}
