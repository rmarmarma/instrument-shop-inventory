/**
 * The specifications 
 * @author Robert Allen
 * @Version 1.0 12/17/2021
 **/ 


import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;


public class InstrumentSpecification {
	private Map<String, Object> propertiesList; 

	/**
	 * Constructor that uses lazy instantialization to initialize the map holding all the properties
	 * @param propertiesList  the map holding the properties of the instrument
	 */
	public InstrumentSpecification(Map<String, Object> propertiesList) {
		this.propertiesList = new HashMap<String, Object>();
		if (propertiesList != null) {
			this.propertiesList.putAll(propertiesList);
		}
	}

	/**
	 * returns the specified property of the instrument
	 * @param desiredProperty  The specific property of the instrument to be returned    
	 * @return Instrument Property
	 */
	public Object getProperty(String desiredProperty) {
		return propertiesList.get(desiredProperty);
	}

	/**
	 * returns a list containing the values within the properties hashmap  
	 * @return Values List
	 */
	public Collection<Object> getProperties() {
		return propertiesList.values();
	}

	/**
	 * returns a list containing the keys within the properties hashmap  
	 * @return Keys List
	 */
	private Collection<String> getKeys() {
		return propertiesList.keySet();
	}

	/**
	 * Compares two instrument specifications and returns true or false if they match
	 * @param specificationBeingComparedTo  The second of the two specifications; the one being compared to
	 * @return True or False
	 */
	public boolean matches(InstrumentSpecification specificationBeingComparedTo) {
		for (String key: specificationBeingComparedTo.getKeys()) {
			if (getProperty(key) != specificationBeingComparedTo.getProperty(key)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * returns the format in which a InstrumentSpecification object should be printed
	 * @return String ouputting the InstrumentSpecification object
	 */
	public String toString() {
		String specInfo = "";
		for (String key: getKeys()) {
			specInfo += key + ": " + getProperty(key) + " ";
		}
		return specInfo;
	}
}