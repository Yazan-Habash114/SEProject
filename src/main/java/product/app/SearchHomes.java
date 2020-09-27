package product.app;

import java.util.ArrayList;
import java.util.Iterator;

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


	
	//add to database list
	public void storeHome(String[] list) {
		Home h = new Home(list[0], list[1], list[2], list[3], list[4], Integer.parseInt(list[5]),
				Integer.parseInt(list[6]), Integer.parseInt(list[7]), 
				Integer.parseInt(list[8]), Integer.parseInt(list[9]));
		homes.add(h);
	}
	
	// return the list of homes and print it to console
	public void printFoundHomes() {
		for(Home h: found_homes)
			System.out.println(h.toString());
		System.out.println("\n");
		this.found_homes.clear();
		combinational = false;
	}


	// search by giving placement
	public ArrayList <Home> searchByPlacement(String value) {
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
		return(this.found_homes);
	}

	//search by giving material 
	public ArrayList <Home> searchByMaterial(String value) {
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
		return(this.found_homes);
	}

	//search by giving price limit
	public ArrayList <Home> searchByPriceBelow(int value) {
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
		return(this.found_homes);
	}
	
	
	//search by giving price range
	public ArrayList <Home> searchByAmenities(String value) {
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
		return(this.found_homes);
	}

	//search by giving lease length
	public ArrayList <Home> searchByLeaseLength(int value) {
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
		return(this.found_homes);
	}

	//search by giving type
	public ArrayList <Home> searchByType(String value) {
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
		return(this.found_homes);
	}

	//search by Allowing pets or not
	public ArrayList <Home> searchByAllowingPets(String value) {
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
		return(this.found_homes);
	}

	//search by giving number of bathrooms
	public ArrayList <Home> searchByNumberOfBathrooms(int num) {
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
		return(this.found_homes);
	}

	//search by giving number of bedrooms
	public ArrayList <Home> searchByNumberOfBedrooms(int num) {
		
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
		return(this.found_homes);
	}

	//search by giving area range 
	public ArrayList <Home> searchBetweenRangeOfAreas(int low, int high) {
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
		return(this.found_homes);
	}

	//search by giving area limit
	public ArrayList <Home> searchByAreaBelow(int area) {
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
		return(this.found_homes);
	}

	//search by giving price range
	public ArrayList <Home> searchByPriceBetweenRange(int low, int high) {
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
		return(this.found_homes);
	}
		
}