package SapientTest;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;

public class CustomURLClassLoader extends ClassLoader {
	
	
	public Class<?> loadClass(String name) throws ClassNotFoundException
	{
		URL url=null;
	//	URL url="file:///c://demo.jar";
		URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {url});
		return urlClassLoader.loadClass("className");
		
	}
	
	public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException
	{
		CustomClassLoader customClassLoader= new CustomClassLoader();
		Class c= customClassLoader.loadClass("Myclass");
		Object obj=c.newInstance();
		Method m=c.getMethod("name");
	}
	

}
