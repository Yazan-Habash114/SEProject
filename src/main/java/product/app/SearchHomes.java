package product.app;

import java.util.ArrayList;

public class SearchHomes {
	
	private ArrayList <Home> homes;
	private ArrayList <Home> found_homes;
	private boolean combinational;
	
	//Constructor
	public SearchHomes() {
		homes = new ArrayList <Home>();
		found_homes = new ArrayList <Home>();
		combinational = false;
	}
	
	
	public void appendHome() {
		
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
