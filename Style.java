/**
 * Enum definition
 * @author Robert Allen
 * @Version 2.0 12/14/2021
 **/ 

public enum Style {
	A, F;
	/**
	 * returns the number of constants within the enum
	 * @return number of constants
	 */
	public static int getCount() {
		int count = 0;
		for (Style value: Style.values()) {
			count++;
		}
		return count;
	}
}