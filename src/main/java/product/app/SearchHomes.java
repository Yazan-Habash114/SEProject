package product.app;

import java.util.ArrayList;
import java.util.Iterator;

public class SearchHomes {
	
	private ArrayList <Home> homes;
	private ArrayList <Home> found_homes;
	private boolean combinational;
	
	// Constructor
	public SearchHomes() {
		this.homes = new ArrayList <Home>();
		this.found_homes = new ArrayList <Home>();
		this.combinational = false;
	}


	
	// Add to database list
	public void storeHome(String[] list) {
		Home h = new Home(list[0], list[1], list[2], list[3], list[4], Integer.parseInt(list[5]),
				Integer.parseInt(list[6]), Integer.parseInt(list[7]), 
				Integer.parseInt(list[8]), Integer.parseInt(list[9]));
		homes.add(h);
	}
	
	// Return the list of homes and print it to console
	public ArrayList <Home> printFoundHomes() {
		if(found_homes.isEmpty()) {
			System.out.println("No homes found !");
			return null;
		}
		for(Home h: found_homes)
			System.out.println(h.toString());
		System.out.println();
		ArrayList <Home> tmp = found_homes;
		this.found_homes = null;
		this.combinational = false;
		return tmp;
	}

	// Search by giving placement
	public void searchByPlacement(String value) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkPlacement(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkPlacement(value))
					found_homes.add(h);
		this.combinational = true;
		return;
	}
	
	// Search by giving material 
	public void searchByMaterial(String value) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkMaterial(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkMaterial(value))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by giving price limit
	public void searchByPriceBelow(int value) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkPriceBelow(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkPriceBelow(value))
					found_homes.add(h);
		this.combinational = true;
		return;
	}
	
	
	// Search by giving price range
	public void searchByAmenities(String value) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkAmenities(value.split(",")))
					it.remove();
		}
		else
			for(Home h : homes)
				if(h.chkAmenities(value.split(",")))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by giving lease length
	public void searchByLeaseLength(int value) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkLeaseLength(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkLeaseLength(value))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by giving type
	public void searchByType(String value) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkType(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkType(value))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by Allowing pets or not
	public void searchByAllowingPets(String value) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkAllowingPets(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkAllowingPets(value))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by giving number of bathrooms
	public void searchByNumberOfBathrooms(int num) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkNumberOfBathrooms(num))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkNumberOfBathrooms(num))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by giving number of bedrooms
	public void searchByNumberOfBedrooms(int num) {
		
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkNumberOfBedrooms(num))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkNumberOfBedrooms(num))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by giving area range 
	public void searchBetweenRangeOfAreas(int low, int high) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkAreaInRange(low, high))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkAreaInRange(low , high))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by giving area limit
	public void searchByAreaBelow(int area) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkAreaBelow(area))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkAreaBelow(area))
					found_homes.add(h);
		this.combinational = true;
		return;
	}

	// Search by giving price range
	public void searchByPriceBetweenRange(int low, int high) {
		if (combinational) {
			Iterator <Home> it = found_homes.iterator();
			while(it.hasNext())
				if(!it.next().chkPriceInRange(low, high))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkPriceInRange(low , high))
					found_homes.add(h);
		this.combinational = true;
		return;
	}
		
}