package SapientTest;

public class CustomExceptionImpl {
	
	public static void main(String[] args)
	{
		try {
			System.out.println("Test");
			throw new CustomException("Error in my program");
		}catch(Exception e) {
			System.out.println(e.getMessage());
	         }
	}

}
