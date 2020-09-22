package product.app;

import java.util.ArrayList;

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
		if (category.equals("Placement"))
			searchByPlacement(value);
		else if (category.equals("Material"))
			searchByMaterial(value);
		else if (category.equals("Price below"))
			searchByPriceBelow(value);
		else if (category.equals("Between range")) {
			String[] range = value.split(",");
			searchByPriceBetweenRange(Integer.parseInt(range[0]),Integer.parseInt(range[1]));
		}
		else if (category.equals("below specific area"))
			searchByAreaBelow(Integer.parseInt(value));
		else if (category.equals("Between range of Areas")) {
			String[] range = value.split(",");
			searchBetweenRangeOfAreas(Integer.parseInt(range[0]),Integer.parseInt(range[1]));
		}
		else if (category.equals("Number of bedrooms"))
			searchByNumberOfBedrooms(Integer.parseInt(value));
		else if (category.equals("Price below"))
			searchByPriceBelow(value);
		else if (category.equals("Price below"))
			searchByPriceBelow(value);
		else if (category.equals("Price below"))
			searchByPriceBelow(value);
		else if (category.equals("Price below"))
			searchByPriceBelow(value);
		else if (category.equals("Price below"))
			searchByPriceBelow(value);		
		combinational = true;
		return;
	}


	private void searchByNumberOfBedrooms(int num) {
		for(Home h : homes)
			if(h.chkNumberOfBedrooms(num))
				found_homes.add(h);
		return;
	}


	private void searchBetweenRangeOfAreas(int low, int high) {
		for(Home h : homes)
			if(h.chkAreaInRange(low , high))
				found_homes.add(h);
		return;
	}


	private void searchByAreaBelow(int area) {
		for(Home h : homes)
			if(h.chkAreaBelow(area))
				found_homes.add(h);
		return;
	}


	private void searchByPriceBetweenRange(int low, int high) {
		for(Home h : homes)
			if(h.chkPriceInRange(low , high))
				found_homes.add(h);
		return;
	}


	private void searchByPriceBelow(String value) {
		for(Home h : homes)
			if(h.chkPriceBelow(Integer.parseInt(value)))
				found_homes.add(h);
		return;
	}


	private void searchByMaterial(String value) {
		for(Home h : homes)
			if(h.chkMaterial(value))
				found_homes.add(h);
		return;
	}


	private void searchByPlacement(String value) {
		for(Home h : homes)
			if(h.chkPlacement(value))
				found_homes.add(h);
		return;
	}
	
}
