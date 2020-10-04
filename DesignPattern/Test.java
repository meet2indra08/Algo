package SapientTest.DesignPattern;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args)
	{

        // Create a list of strings 
        List<String> colorsList = Arrays.asList("Red", "Green", 
                    "Blue", "Cyan", "Magenta", "Yellow"); 
        System.out.println("Original List:" + colorsList);
        // Convert to set using stream and Collectors class toSet() method 
        Set<String> colorsSet = colorsList.stream().collect(Collectors.toSet()); 
        System.out.println("The set from list:");
        //print the set
       for (String x : colorsSet) 
            System.out.print(x + " "); 
	}
}
