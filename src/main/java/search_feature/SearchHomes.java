package search_feature;

import java.util.ArrayList;

public class SearchHomes {
	
	ArrayList <Home> homes;
	ArrayList <Home> found_homes;
	
	//Constructor
	public SearchHomes() {
		homes = new ArrayList <Home>();
		found_homes = new ArrayList <Home>();
	}
	
	// Methods
	public void appendHome() {
		
	}
	
	public void printFoundHomes() {
		for(Home h: found_homes)
			System.out.println(h.toString());
	}
}
