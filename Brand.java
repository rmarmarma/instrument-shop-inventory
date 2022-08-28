/**
 * Enum definition
 * @author Robert Allen
 * @Version 2.0 11/5/2021
 **/ 

public enum Brand {
	GIBSON, FENDER, IBANEZ, PAULREEDSMITH, EPIPHONE, JACKSON, ESP, YAMAHA, RICKENBACKER, GRETSCH; 
	/**
	 * returns the number of constants within the enum
	 * @return number of constants
	 */
	public static int getCount() {
		int count = 0;
		for (Brand value: Brand.values()) {
			count++;
		}
		return count;
	}
}