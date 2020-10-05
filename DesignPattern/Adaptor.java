package SapientTest.DesignPattern;

 
interface Bird 
{ 
    // birds implement Bird interface that allows 
    // them to fly and make sounds adaptee interface 
    public void fly(); 
    public void makeSound(); 
}
/*
 * class Sparrow1 implements Bird { // a concrete implementation of bird public
 * void fly() { System.out.println("Flying"); } public void makeSound() {
 * System.out.println("dddddddChirp Chirp"); } }
 */
  
class Sparrow implements Bird 
{ 
    // a concrete implementation of bird 
    public void fly() 
    { 
        System.out.println("Flying"); 
    } 
    public void makeSound() 
    { 
        System.out.println("Chirp Chirp"); 
    } 
}


  
interface ToyDuck 
{ 
    // target interface 
    // toyducks dont fly they just make 
    // squeaking sound 
    public void squeak(); 
} 
  
class PlasticToyDuck implements ToyDuck 
{ 
    public void squeak() 
    { 
        System.out.println("Squeak"); 
    } 
} 
  
class BirdAdapter implements ToyDuck 
{ 
    // You need to implement the interface your 
    // client expects to use. 
    Bird bird; 
    public BirdAdapter(Bird bird) 
    { 
        // we need reference to the object we 
        // are adapting 
        this.bird = bird; 
    } 
  
    public void squeak() 
    { 
        // translate the methods appropriately 
        bird.makeSound(); 
    } 
} 
  
class Adaptor 
{ 
    public static void main(String args[]) 
    { 
        Sparrow sparrow = new Sparrow(); 
        ToyDuck toyDuck = new PlasticToyDuck(); 
  
        // Wrap a bird in a birdAdapter so that it  
        // behaves like toy duck 
        ToyDuck birdAdapter = new BirdAdapter(sparrow); 
  
        System.out.println("Sparrow..."); 
        sparrow.fly(); 
        sparrow.makeSound(); 
  
        System.out.println("ToyDuck..."); 
        toyDuck.squeak(); 
  
        // toy duck behaving like a bird  
        System.out.println("BirdAdapter..."); 
        birdAdapter.squeak(); 
    } 
} 

public interface AddressValidator {
public boolean isValidAddress(String inp_address,
String inp_zip, String inp_state);
}//end of class


class CAAddress {
public boolean isValidCanadianAddr(String inp_address,
String inp_pcode, String inp_prvnc) {
if (inp_address.trim().length() < 15)
return false;
if (inp_pcode.trim().length() != 6)
return false;
if (inp_prvnc.trim().length() < 6)
return false;
return true;
}
}//end of class

class CAAddressAdapter extends CAAddress
implements AddressValidator {
public boolean isValidAddress(String inp_address,
String inp_zip, String inp_state) {
return isValidCanadianAddr(inp_address, inp_zip,
inp_state);
}
}//end of class

class Customer {
public boolean isValidAddress() {
//get an appropriate address validator
AddressValidator validator = getValidator(type);
//Polymorphic call to validate the address
return validator.isValidAddress(address, zip, state);
}
private AddressValidator getValidator(String custType) {
AddressValidator validator = null;
if (custType.equals(Customer.US)) {
validator = new USAddress();
static volatile String a;
}
return validator;
}
}//end of class