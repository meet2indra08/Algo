package SapientTest.DesignPattern;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Random;

import javax.management.InstanceAlreadyExistsException;

public class MySingleton implements Serializable {

	private static MySingleton obj = null;
	private int val;

	private MySingleton() throws InstanceAlreadyExistsException {
		if (obj != null) {
			throw new InstanceAlreadyExistsException();
		}
		val = new Random().nextInt();
	}

	private static MySingleton getInstance() throws InstanceAlreadyExistsException {
		if (obj != null) {
			synchronized (MySingleton.class) {
				if (obj == null) {
					obj = new MySingleton();
				}

			}
		}
		return obj;

	}

	protected MySingleton clone() throws CloneNotSupportedException {
		try {
			return MySingleton.getInstance();
		} catch (InstanceAlreadyExistsException e) {
		}
		return null;

	}

	private Object readResolve() throws ObjectStreamException, InstanceAlreadyExistsException {
		// We are blocking deserilizing object and sending same class object
		return MySingleton.getInstance();
	}
}
