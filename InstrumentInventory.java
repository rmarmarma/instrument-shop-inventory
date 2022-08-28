import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * An inventory system that manages instruments
 * @author Robert Allen
 * @Version 1.0 12/17/2021
 **/ 

public class InstrumentInventory {
	private Map<String, Instrument> instrumentInventory = new HashMap<String, Instrument>();

	/**
	 * Adds a string instrument to the inventory and returns the newly added string instrument
	 * @param instrument  The instrument to be added
	 * @return 
	 */
	public Instrument addInstrument(Instrument instrument) {
		instrumentInventory.put(instrument.getSerialNumber(), instrument);
		return instrument;
	}

	/**
	 * Removes a instrument from the inventory
	 * @param serialNumber  The serial number of the instrument to be removed
	 */
	public void removeInstrument(String serialNumber) {
		instrumentInventory.remove(serialNumber);
	}

	/**
	 * Modifies a instrument in the inventory
	 * @param serialNumber 	The serial number of the instrument to be modified
	 * @param newSpecification  The specification that will be present in the modified instrument
	 * @param newPrice 	The price of the modified instrument
	 */
	public void modifyInstrument(String serialNumber, InstrumentSpecification newSpecification, double newPrice) {
		Instrument newInstrument = instrumentInventory.get(serialNumber);
		newInstrument.setNewInstrumentSpecification(newSpecification);
		newInstrument.setPrice(newPrice);		//Don't need to check for negative price here because those checks happen in the setPrice method
		instrumentInventory.replace(serialNumber, newInstrument);
	}

	/**
	 * Retrives a instrument from the inventory
	 * @param serialNumber  The serial number of the instrument to be retrieved
	 */
	public Instrument getInstrument(String serialNumber) {
		Instrument desiredInstrument = instrumentInventory.get(serialNumber);
		return desiredInstrument;
	}

	/** Prints all of the instruments in the inventory */
	public void displayAllInstruments() {
		System.out.println("All instruments in inventory: ");
		for (Instrument instrumentInInventory: instrumentInventory.values()) {
			System.out.println(instrumentInInventory);
		}
	}

	/**
	 * returns the number of instruments in the inventory
	 * @return Inventory Size
	 */
	public int getNumberOfInstrumentsInInventory() {
		return instrumentInventory.size();
	}

	/**
	 * Compares a instrumentspecification to each instrument in the inventory and returns a list, sorted in ascending order by price, of instruments that fit the criteria
	 * @param instrumentSpecification 	The instrumentspecification to be compared to all the instruments in the inventory
	 * @return List of matching instruments
	 */
	public List<Instrument> search(InstrumentSpecification instrumentSpecification) {
		List<Instrument> instrumentThatMatchSpecification = new ArrayList<Instrument>();
		for (Instrument instrumentInInventory: instrumentInventory.values()) {
			if (instrumentInInventory.getInstrumentSpecification().matches(instrumentSpecification) == true) {
				instrumentThatMatchSpecification.add(instrumentInInventory);
			}
		}
		if (instrumentThatMatchSpecification.size() > 0) {
			Collections.sort(instrumentThatMatchSpecification);
		}
		return instrumentThatMatchSpecification;
	}
}