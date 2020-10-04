package SapientTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import javax.swing.text.DefaultEditorKit.CutAction;

public class CustomClassLoader extends ClassLoader {

	public Class<?> findClass(String name) {
		byte[] bt = null;
		try {
			bt = loadClassData(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return defineClass(name, bt, 0, bt.length);

	}

	private byte[] loadClassData(String className) throws IOException {
		InputStream is = getClass().getClassLoader().getResourceAsStream(className + ".class");
		ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
		int len = 0;
		while ((len = is.read()) != -1) {
			byteSt.write(len);
		}
		return byteSt.toByteArray();

	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException 
	{
		CustomClassLoader classloader= new CustomClassLoader();
		Class<?> c=classloader.findClass("com.concretepage.lang.Test");
		Object ob=c.newInstance();
		Method mb=c.getMethod("Method Name");
		
		
	}

	

}
