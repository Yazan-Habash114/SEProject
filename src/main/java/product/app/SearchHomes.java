package product.app;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SearchHomes {

	private static final Logger LOGGER = Logger.getLogger(SearchHomes.class.getName());
	private ArrayList<Home> homes;
	private ArrayList<Home> foundHomes;
	private boolean combinational;
	private EmailServiceThirdParty estp;
	private String listOfFoundHomesToPrint;

	public String getListOfFoundHomesToPrint() {
		return listOfFoundHomesToPrint;
	}

	// Constructor
	public SearchHomes() {
		this.homes = new ArrayList<Home>();
		this.foundHomes = new ArrayList<Home>();
		this.combinational = false;
	}

	// Add to database list
	public void storeHome(String[] list) {
		Home h = new Home(list);
		homes.add(h);
	}

	// Return the list of homes and print it to console
	public List<Home> printFoundHomes() {
		listOfFoundHomesToPrint = stringOfListOfFoundHomes();
		send(listOfFoundHomesToPrint);
		LOGGER.info(listOfFoundHomesToPrint);
		ArrayList<Home> tmp = foundHomes;
		this.foundHomes.clear();
		this.combinational = false;
		return (tmp);
	}

	private String stringOfListOfFoundHomes() {
		StringBuilder listOfFoundHomes = new StringBuilder();
		listOfFoundHomes.append("\n");
		if (foundHomes.isEmpty()) {
			listOfFoundHomes.append("No homes found, try search for another specifications :)\n");
		} else {
			for (Home h : foundHomes)
				listOfFoundHomes.append(h.toString() + "\n");
		}
		String returnString = listOfFoundHomes.toString();
		return (returnString);
	}

	public void send(String data) {
		String email = "yazanalhabash5@gmail.com";
		estp.sendEmail(email, data);
	}

	public void setService(EmailServiceThirdParty es) {
		this.estp = es;
	}

	// Search by amenities
	public void searchByAmenities(String amenities) {
		GeneralCheckBy specification = new ByAmenities(amenities);
		searchBySpec(specification);
	}

	// Search by giving lease length
	public void searchByLeaseLength(int leaseLength) {
		GeneralCheckBy specification = new ByLeaseLength(leaseLength);
		searchBySpec(specification);
	}

	// Search by giving placement
	public void searchByPlacement(String value) {
		GeneralCheckBy specification = new ByPlacement(value);
		searchBySpec(specification);
	}

	// Search by giving material
	public void searchByMaterial(String value) {
		GeneralCheckBy specification = new ByMaterial(value);
		searchBySpec(specification);
	}

	// Search by giving price limit
	public void searchByPriceBelow(int value) {
		GeneralCheckBy specification = new ByPriceBelow(value);
		searchBySpec(specification);
	}

	// Search by giving type
	public void searchByType(String value) {
		GeneralCheckBy specification = new ByType(value);
		searchBySpec(specification);
	}

	// Search by Allowing pets or not
	public void searchByAllowingPets(String value) {
		GeneralCheckBy specification = new ByPets(value);
		searchBySpec(specification);
	}

	// Search by giving number of bathrooms
	public void searchByNumberOfBathrooms(int num) {
		GeneralCheckBy specification = new ByNumBathrooms(num);
		searchBySpec(specification);
	}

	// Search by giving number of bedrooms
	public void searchByNumberOfBedrooms(int num) {
		GeneralCheckBy specification = new ByNumBedrooms(num);
		searchBySpec(specification);
	}

	// Search by giving area range
	public void searchBetweenRangeOfAreas(int low, int high) {
		GeneralCheckBy specification = new ByAreaBetween(low, high);
		searchBySpec(specification);
	}

	// Search by giving area limit
	public void searchByAreaBelow(int area) {
		GeneralCheckBy specification = new ByAreaBelow(area);
		searchBySpec(specification);
	}

	// Search by giving price range
	public void searchByPriceBetweenRange(int low, int high) {
		GeneralCheckBy specification = new ByPriceBetween(low, high);
		searchBySpec(specification);
	}

	// Search by general specification
	private void searchBySpec(GeneralCheckBy specification) {
		if (combinational) {
			for (Home h : homes)
				if (!specification.isMatched(h))
					foundHomes.remove(h);
		} else
			for (Home h : homes)
				if (specification.isMatched(h))
					foundHomes.add(h);
		this.combinational = true;
	}

}
