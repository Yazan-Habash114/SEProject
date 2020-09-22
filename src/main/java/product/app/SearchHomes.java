package product.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchHomes {
	
	private ArrayList <Home> homes;
	private ArrayList <Home> found_homes;
	private Map <String, String> DB;
	private boolean combinational;
	
	//Constructor
	public SearchHomes() {
		this.homes = new ArrayList <Home>();
		this.found_homes = new ArrayList <Home>();
		this.DB = new HashMap<String, String>();
		this.combinational = false;
	}
	
	public Map <String, String> getDB() {
		return(this.DB);
	}
	
	public void storeHome() {
		
	}
	
	public void setDB(Map <String, String> DB) {
		this.DB = DB; // Save the data (Map)
		produceHome(); // Splitting and produce object 'Home'
	}
	
	private void produceHome() {
		String key, value;
		String[] words, numbers; // words = key, numbers = value of the Map
		String[] amenities; // Saving the amenities
		for(Map.Entry<String, String> entry : this.DB.entrySet()) {
			key = entry.getKey();
			value = entry.getValue();
			words = key.split("_");
			numbers = value.split("_");
			amenities = words[words.length-1].split(","); // Last element in the array
			//System.out.println(entry.getKey() + "   " + entry.getValue());
		}
	}
	
	public void printFoundHomes() {
		for(Home h: found_homes)
			System.out.println(h.toString());
		found_homes.clear();
		combinational = false;
	}

	public void searchBy(String string) {
		
	}
}
