/**
 * Enum definition
 * @author Robert Allen
 * @Version 1.0 12/14/2021
 **/ 

public enum InstrumentName {
	GUITAR, MANDOLIN, BANJO, DOBRO, FIDDLE, BASS;
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