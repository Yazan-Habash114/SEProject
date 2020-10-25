package product.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class SearchHomes {
	private static final Logger LOGGER = Logger.getLogger(SearchHomes.class.getName());
	private ArrayList <Home> homes;
	private ArrayList <Home> foundHomes;
	private boolean combinational;
	
	// Constructor
	public SearchHomes() {
		this.homes = new ArrayList <Home>();
		this.foundHomes = new ArrayList <Home>();
		this.combinational = false;
	}


	
	// Add to database list
	public void storeHome(String[] list) {
		Home h = new Home(list);
		homes.add(h);
	}
	
	// Return the list of homes and print it to console
	public List <Home> printFoundHomes() {
		if(foundHomes.isEmpty()) {
			LOGGER.info("No homes found, try search for another specifications :)\n");
			return (foundHomes);
		}
		StringBuilder listOfFoundHomes = new StringBuilder();
		for(Home h: foundHomes)
			listOfFoundHomes.append(h.toString()+"\n");
		LOGGER.fine("\n" + listOfFoundHomes);
		ArrayList <Home> tmp = foundHomes;
		this.foundHomes = null;
		this.combinational = false;
		return (tmp);
	}

	// Search by giving placement
	public void searchByPlacement(String value) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkPlacement(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkPlacement(value))
					foundHomes.add(h);
		this.combinational = true;
	}
	
	// Search by giving material 
	public void searchByMaterial(String value) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkMaterial(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkMaterial(value))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by giving price limit
	public void searchByPriceBelow(int value) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkPriceBelow(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkPriceBelow(value))
					foundHomes.add(h);
		this.combinational = true;
	}
	
	
	// Search by giving price range
	public void searchByAmenities(String value) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkAmenities(value.split(",")))
					it.remove();
		}
		else
			for(Home h : homes)
				if(h.chkAmenities(value.split(",")))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by giving lease length
	public void searchByLeaseLength(int value) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkLeaseLength(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkLeaseLength(value))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by giving type
	public void searchByType(String value) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkType(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkType(value))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by Allowing pets or not
	public void searchByAllowingPets(String value) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkAllowingPets(value))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkAllowingPets(value))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by giving number of bathrooms
	public void searchByNumberOfBathrooms(int num) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkNumberOfBathrooms(num))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkNumberOfBathrooms(num))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by giving number of bedrooms
	public void searchByNumberOfBedrooms(int num) {
		
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkNumberOfBedrooms(num))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkNumberOfBedrooms(num))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by giving area range 
	public void searchBetweenRangeOfAreas(int low, int high) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkAreaInRange(low, high))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkAreaInRange(low , high))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by giving area limit
	public void searchByAreaBelow(int area) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkAreaBelow(area))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkAreaBelow(area))
					foundHomes.add(h);
		this.combinational = true;
	}

	// Search by giving price range
	public void searchByPriceBetweenRange(int low, int high) {
		if (combinational) {
			Iterator <Home> it = foundHomes.iterator();
			while(it.hasNext())
				if(!it.next().chkPriceInRange(low, high))
					it.remove();
		}
		else 
			for(Home h : homes)
				if(h.chkPriceInRange(low , high))
					foundHomes.add(h);
		this.combinational = true;
	}
		
}