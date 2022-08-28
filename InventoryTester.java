import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Tests the functionalities of the other instrument related classes: InstrumentSpecifications, Instrument, and InstrumentInventory
 * @author Robert Allen
 * @Version 1.0 12/14/2021
 **/ 

public class InventoryTester {
	private static Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * Helper method that fills in a given map with the properties of an instrument
	 * @param mapToBeFilled  the map that will be added to
	 * @param instrumentName the name of the specific instrument
	 * @param brand  the brand of the instrument
	 * @param model  the model of the instrument
	 * @param topWood  the wood used for the topside of the instrument
	 * @param bottomWood  the wood used for the bottomside of the instrument
	 * @param type  the type of the instrument
	 * @param style  the style of the instrument
	 */
	private static void fillMapWithGivenValues(Map<String, Object> mapToBeFilled, InstrumentName instrumentName, Brand brand, Model model, Wood topWood, Wood bottomWood, Type type, Style style) {
		mapToBeFilled.put("InstrumentName", instrumentName);
		mapToBeFilled.put("Brand", brand);
		mapToBeFilled.put("Model", model);
		mapToBeFilled.put("TopWood", topWood);
		mapToBeFilled.put("BottomWood", bottomWood);
		mapToBeFilled.put("Type", type);
		mapToBeFilled.put("Style", style);
	}

	/**
	 * Initializes an inventory to have at least one from each specific instrument
	 * @param inventory  The inventory to be initialized
	 * @param map  The map being used to hold Instrument properties
	 */
	private static void initializeInventory(InstrumentInventory inventory, Map<String, Object> map) {
		System.out.println("Number of Instruments in inventory before initialization: " + inventory.getNumberOfInstrumentsInInventory());
		System.out.println("Initializing***");
		InstrumentName instrumentNameValues[] = InstrumentName.values();
		Brand brandValues[] = Brand.values();	//values() creates a copy of the collection everytime its called which takes O(n) time and so I wanted to
		Model modelValues[] = Model.values();	//make sure it wasn't being called dozens of times inside of the for loop which is why I made these arrays
		Wood woodValues[] = Wood.values();		//that only need to be created once.
		Type typeValues[] = Type.values();
		Style styleValues[] = Style.values();
		int brandCount = Brand.getCount(); 
		int modelCount = Model.getCount();
		int woodCount = Wood.getCount();
		int typeCount = Type.getCount();
		int styleCount = Style.getCount();
		Random rand = new Random();				//Using random just so the inventory has something new each time
		for (InstrumentName instrumentName: instrumentNameValues) {
			Brand brand = brandValues[rand.nextInt(brandCount)];
			Model model = modelValues[rand.nextInt(modelCount)];
			Wood topWood = woodValues[rand.nextInt(woodCount)];
			Wood bottomWood = woodValues[rand.nextInt(woodCount)];
			Type type = typeValues[rand.nextInt(typeCount)];
			Style style = styleValues[rand.nextInt(styleCount)]; 
			fillMapWithGivenValues(map, instrumentName, brand, model, topWood, bottomWood, type, style);
			InstrumentSpecification instrumentSpecification = new InstrumentSpecification(map);
			Instrument instrument = new Instrument(instrumentSpecification, (1500 + 3500 * rand.nextDouble()));
			inventory.addInstrument(instrument);	//Generate random prices between 1500 and 5000 dollars. 
		}
		System.out.println("Number of instruments in inventory after initialization: " + inventory.getNumberOfInstrumentsInInventory());
	}

	/**
	 * Tests the add function from the InstrumentInventory class
	 * @param inventory  The inventory to be added to
	 * @param map  The map being used to hold Instrument properties
	 */
	private static void addTest(InstrumentInventory inventory, Map<String, Object> map) {
		System.out.println("Number of instruments in inventory before adding: " + inventory.getNumberOfInstrumentsInInventory());
		System.out.println("Adding***");
		map.clear();
		map.put("InstrumentName", InstrumentName.BANJO);
		map.put("Model", Model.CLASSIC);
		map.put("Wood", Wood.CEDAR);
		map.put("Wood", Wood.MAHOGANY);
		map.put("Type", Type.ACOUSTIC);
		map.put("Style", Style.A);
		InstrumentSpecification instrumentSpecification = new InstrumentSpecification(map);
		Instrument instrument = new Instrument(instrumentSpecification, 3000);
		map.clear();
		map.put("InstrumentName", InstrumentName.FIDDLE);
		map.put("Wood", Wood.ALDER);
		map.put("Wood", Wood.MAHOGANY);
		map.put("Type", Type.ACOUSTIC);
		InstrumentSpecification instrumentSpecification2 = new InstrumentSpecification(map);
		Instrument instrument2 = new Instrument(instrumentSpecification2, 2500);
		map.clear();
		map.put("InstrumentName", InstrumentName.GUITAR);
		map.put("Brand", Brand.GIBSON);
		map.put("Model", Model.VINTAGE);
		map.put("Wood", Wood.ROSEWOOD);
		map.put("Wood", Wood.ROSEWOOD);
		map.put("Type", Type.ELECTRIC);
		map.put("Style", Style.F);
		InstrumentSpecification instrumentSpecification3 = new InstrumentSpecification(map); 
		Instrument instrument3 = new Instrument(instrumentSpecification3, 2750);
		inventory.addInstrument(instrument);
		inventory.addInstrument(instrument2);
		inventory.addInstrument(instrument3);
		System.out.println("Number of instruments in inventory after adding: " + inventory.getNumberOfInstrumentsInInventory());
	}

	/**
	 * Tests the remove function from the InstrumentInventory class
	 * @param inventory  The inventory to be removed from
	 * @param map  The map being used to hold Instrument properties
	 */
	private static void removeTest(InstrumentInventory inventory, Map<String, Object> map) {
		map.clear();
		map.put("InstrumentName", InstrumentName.MANDOLIN);
		map.put("Brand", Brand.IBANEZ);
		map.put("Model", Model.CLASSIC);
		map.put("Wood", Wood.CEDAR);
		map.put("Wood", Wood.MAHOGANY);
		map.put("Type", Type.ACOUSTIC);
		map.put("Style", Style.A);
		InstrumentSpecification instrumentSpecification = new InstrumentSpecification(map); 
		Instrument instrument = new Instrument(instrumentSpecification, 3500);
		map.clear();
		map.put("InstrumentName", InstrumentName.FIDDLE);
		map.put("Wood", Wood.ALDER);
		map.put("Wood", Wood.MAHOGANY);
		InstrumentSpecification instrumentSpecification2 = new InstrumentSpecification(map);
		Instrument instrument2 = new Instrument(instrumentSpecification2, 2900);
		map.clear();
		map.put("InstrumentName", InstrumentName.GUITAR);
		map.put("Brand", Brand.GIBSON);
		map.put("Model", Model.VINTAGE);
		map.put("Wood", Wood.ROSEWOOD);
		map.put("Wood", Wood.ROSEWOOD);
		map.put("Type", Type.ELECTRIC);
		map.put("Style", Style.F);
		InstrumentSpecification instrumentSpecification3 = new InstrumentSpecification(map);
		Instrument instrument3 = new Instrument(instrumentSpecification3, 1870);
		instrument = inventory.addInstrument(instrument);
		instrument2 = inventory.addInstrument(instrument2);
		instrument3 = inventory.addInstrument(instrument3);
		System.out.println("Number of instruments in inventory before removing: " + inventory.getNumberOfInstrumentsInInventory());
		System.out.println("Removing***");
		inventory.removeInstrument(instrument.getSerialNumber());
		System.out.println("Number of instruments in inventory after removing once: " + inventory.getNumberOfInstrumentsInInventory());
		inventory.removeInstrument(instrument2.getSerialNumber());
		System.out.println("Number of instruments in inventory after removing twice: " + inventory.getNumberOfInstrumentsInInventory());
		inventory.removeInstrument(instrument3.getSerialNumber());
		System.out.println("Number of instruments in inventory after removing three times: " + inventory.getNumberOfInstrumentsInInventory());
	}

	/**
	 * Tests the modify function from the InstrumentInventory class
	 * @param inventory  The inventory that holds the instrument to be modified
	 * @param map  The map being used to hold Instrument properties
	 */
	private static void modifyTest(InstrumentInventory inventory, Map<String, Object> map) {
		map.clear();
		map.put("InstrumentName", InstrumentName.DOBRO);
		map.put("Brand", Brand.YAMAHA);
		map.put("Wood", Wood.MAHOGANY);
		map.put("Type", Type.ELECTRIC);
		InstrumentSpecification instrumentSpecificationToBeReplaced = new InstrumentSpecification(map);
		Instrument instrument = new Instrument(instrumentSpecificationToBeReplaced, 3100); 
		instrument = inventory.addInstrument(instrument);
		System.out.println("Instrument before modification: " + instrument);
		System.out.println("Modifying***");
		map.clear();
		map.put("InstrumentName", InstrumentName.GUITAR);
		map.put("Brand", Brand.FENDER);
		map.put("Model", Model.VINTAGE);
		map.put("Wood", Wood.ALDER);
		map.put("Wood", Wood.CEDAR);
		map.put("Type", Type.ACOUSTIC);
		InstrumentSpecification newInstrumentSpecifications = new InstrumentSpecification(map);
		inventory.modifyInstrument(instrument.getSerialNumber(), newInstrumentSpecifications, 2700);
		System.out.println("Instrument after modification: " + instrument);
	}

	/**
	 * Tests the search function from the InstrumentInventory class
	 * @param inventory  The inventory to be searched
	 * @param map  The map being used to hold Instrument properties
	 */
	private static void searchTest(InstrumentInventory inventory, Map<String, Object> map) {
		System.out.println("Searching***");
		System.out.println("Search for a specific instrument");
		map.clear();
		map.put("InstrumentName", InstrumentName.GUITAR);
		InstrumentSpecification instrumentIWant = new InstrumentSpecification(map);
		List<Instrument> instrumentsThatMatchSpecifications = inventory.search(instrumentIWant);
		System.out.println(instrumentsThatMatchSpecifications);
		System.out.println(" ");
		System.out.println("Search for specific instrument with alongside other properties");
		map.clear();
		map.put("InstrumentName", InstrumentName.GUITAR);
		map.put("Brand", Brand.FENDER);
		map.put("Model", Model.VINTAGE);
		map.put("Wood", Wood.ALDER);
		map.put("Wood", Wood.CEDAR);
		InstrumentSpecification instrumentIWant2 = new InstrumentSpecification(map);
		List<Instrument> instrumentsThatMatchSpecifications2 = inventory.search(instrumentIWant2);
		System.out.println(instrumentsThatMatchSpecifications2);
	}

	/**
	 * Tests the display function from the InstrumentInventory class
	 * @param inventory  The inventory to be displayed
	 */
	private static void displayTest(InstrumentInventory inventory) {
		System.out.println("Displaying***");
		inventory.displayAllInstruments();
	}

	/**
	 * Calls the testing functions provided above
	 * @param args  Command line arguments (not applicable in this case)
	 */
	public static void main(String[] args) {
		InstrumentInventory inventory = new InstrumentInventory();
		System.out.println("****TESTING INITIALIZATION METHOD****");
		initializeInventory(inventory, map);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("****TESTING ADD METHOD****");
		addTest(inventory, map);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("****TESTING REMOVE METHOD****");
		removeTest(inventory, map);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("****TESTING MODIFY METHOD****");
		modifyTest(inventory, map);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("****TESTING SEARCH METHOD****");
		searchTest(inventory, map);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("****TESTING DISPLAY METHOD****");
		displayTest(inventory);


	}
}