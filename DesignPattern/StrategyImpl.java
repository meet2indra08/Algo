package SapientTest.DesignPattern;

import java.util.ArrayList;
import java.util.List;

interface PaymentStareatgy{
	void pay(int amount);
}

class CreaditCardStreagy implements PaymentStareatgy
{
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	CreaditCardStreagy(String nm, String ccNum, String cvv, String expiryDate){
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}
	
	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println("PayWith CreditCard");
		
	}
	
}

class PaypalStrategy implements PaymentStareatgy
{

	private String emailId;
	private String password;
	
	PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}
	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
		System.out.println("Pay with Paypal");
		
	}
	
}

class Item {

	private String upcCode;
	private int price;
	
	public Item(String upc, int cost){
		this.upcCode=upc;
		this.price=cost;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public int getPrice() {
		return price;
	}
	
}

class ShoppingCart {

	//List of items
	List<Item> items;
	
	public ShoppingCart(){
		this.items=new ArrayList<Item>();
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}
	
	public void removeItem(Item item){
		this.items.remove(item);
	}
	
	public int calculateTotal(){
		int sum = 0;
		for(Item item : items){
			sum += item.getPrice();
		}
		return sum;
	}
	
	public void pay(PaymentStareatgy paymentMethod){
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}

public class StrategyImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
ShoppingCart cart = new ShoppingCart();
		
		Item item1 = new Item("1234",10);
		Item item2 = new Item("5678",40);
		
		cart.addItem(item1);
		cart.addItem(item2);
		
cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));
		
		//pay by credit card
		cart.pay(new CreaditCardStreagy("Pankaj Kumar", "1234567890123456", "786", "12/15"));
	}


}
