/**
 * Models an instrument
 * @author Robert Allen
 * @Version 1.0 12/17/2021
 **/ 

public class Instrument implements Comparable<Instrument> {
	private String serialNumber;
	private InstrumentSpecification instrumentSpecification;
	private double price;
	private static int instrumentCount = 1;	

	/**
	 * Constructor for instrument objects that initializes the specifications, price, and serial number for the instrument as well as incrementing the count
	 * @param instrumentSpecification  the specifications of the instrument
	 * @param price  the price of the instrument
	 */
	public Instrument(InstrumentSpecification instrumentSpecification, double price) {
		if (price < 0) {
			throw new IllegalArgumentException("An instrument cannot have a negative price");
		}
		if (instrumentSpecification.getProperty("InstrumentName") == null) {
			throw new IllegalArgumentException("The specific instrument must be specified. It can't be just instrument.");
		} 
		this.instrumentSpecification = instrumentSpecification;
		this.price = price;
		this.serialNumber = "N" + instrumentCount + "RGS310";	//N stands for number, RGS stands for Rick's Guitar Shop and 310 is the course number
		instrumentCount++;
	}

	/**
	 * returns the price of the instrument
	 * @return Instrument Price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * sets new price for the instrument
	 * @param newPrice  the new price that will replace the old one
	 */
	public void setPrice(double newPrice) {
		if (newPrice < 0) {
			throw new IllegalArgumentException("An instrument cannot have a negative price");
		}
		price = newPrice;
	}

	/**
	 * returns the specifications of the instrument
	 * @return Instrument Specifications
	 */
	public InstrumentSpecification getInstrumentSpecification() {
		return instrumentSpecification;
	}

	/**
	 * sets new specifications for the instrument
	 * @param newInstrumentrSpecification 	the new instrument specifications that will replace the old set
	 */
	public void setNewInstrumentSpecification(InstrumentSpecification newInstrumentSpecification) {
		instrumentSpecification = newInstrumentSpecification;
	}

	/**
	 * returns the serial number of the instrument
	 * @return Instrument Serial Number
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * returns the format in which an instrument object should be printed
	 * @return String ouputting the instrument object
	 */
	public String toString() {
		return ("Serial Number:" + serialNumber +  "  " + instrumentSpecification + "  Price: $" + String.format("%.2f", price));
	}

	/**
	 * Compares the price of this instrument against the price of another
	 * @param instrumentBeingComparedTo  the instrument whose price is being compared to
	 * @return positive if this instrument's price is greater, negative if the other instrument's price is greater, and zero if they are equal
	 */
	public int compareTo(Instrument instrumentBeingComparedTo) {
		if (price > instrumentBeingComparedTo.getPrice()) {
			return 1;
		}
		else if (price < instrumentBeingComparedTo.getPrice()) {
			return -1;
		}
		return 0;
	}
}