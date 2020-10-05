package SapientTest.DesignPattern;

interface Car
{
	public void assemple();
}

class BasicCar implements Car
{

	@Override
	public void assemple() {
		// TODO Auto-generated method stub
	System.out.println("Basic implementation");	
	}
	
}

class CarDecorator implements Car
{
	
	Car car;
	CarDecorator(Car car)
	{
		this.car=car;
	}
	

	@Override
	public void assemple() {
		// TODO Auto-generated method stub
		System.out.println("Decorator aameble 1");
		this.car.assemple();
		System.out.println("Decorator aameble 2");
	}
	
}

class SportCar extends CarDecorator
{

	SportCar(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	
	public void assemple() {
		System.out.println("Sport car aameble 1");
		super.assemple();
		System.out.println("Sport car aameble 2");
		//add some more funtionality 
	}
}

class LuxaryCar extends CarDecorator
{
	LuxaryCar(Car car)
	{
		super(car);
	}
	
	public void assemple()
	{
		System.out.println("Lux car aameble 1");
		super.assemple();
		//add on behaviour
		System.out.println("Lux car aameble 2");
	}
	
}

	

public class DecoratorMain {
	
	public static void main(String[] args)
	{
		Car sportsCar = new SportCar(new BasicCar());
        sportsCar.assemple();
        
        Car luxary= new LuxaryCar(new BasicCar());
        luxary.assemple();
	}

}
