/**
 * Enum definition
 * @author Robert Allen
 * @Version 2.0 11/5/2021
 **/

public enum Model {
	VINTAGE, CLASSIC, MODERN;
	/**
	 * returns the number of constants within the enum
	 * @return number of constants
	 */
	public static int getCount() {
		int count = 0;
		for (Model value: Model.values()) {
			count++;
		}
		return count;
	}
}