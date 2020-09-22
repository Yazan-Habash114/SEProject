package product.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchHomes {
	
	private ArrayList <Home> homes;
	private ArrayList <Home> found_homes;
	private boolean combinational;
	
	//Constructor
	public SearchHomes() {
		this.homes = new ArrayList <Home>();
		this.found_homes = new ArrayList <Home>();
		this.combinational = false;
	}
	
	
	public void storeHome(String[] list) {
		Home h = new Home(list[0], list[1], list[2], list[3], list[4], Integer.parseInt(list[5]),
				Integer.parseInt(list[6]), Integer.parseInt(list[7]), 
				Integer.parseInt(list[8]), Integer.parseInt(list[9]));
		homes.add(h);
		return;
	}
	
	
	public void printFoundHomes() {
		for(Home h: found_homes)
			System.out.println(h.toString());
		found_homes.clear();
		combinational = false;
	}

	public void searchBy(String category, String value) {
		
	}
	
}
