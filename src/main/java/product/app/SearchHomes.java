package product.app;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SearchHomes {
	
	private static final Logger LOGGER = Logger.getLogger(SearchHomes.class.getName());
	private List<Home> homes;
	private List<Home> foundHomes;
	private EmailServiceThirdParty estp;
	private String listOfFoundHomesToPrint;
	private boolean combinational;

	// Constructor
	public SearchHomes() {
		this.homes = new ArrayList<Home> ();
		this.foundHomes = new ArrayList<Home> ();
		this.combinational = false;
	}

	public String getListOfFoundHomesToPrint() {
		return listOfFoundHomesToPrint;
	}

	// Add to database list
	public void storeHome(String[] list) {
		Home h = new Home(list);
		homes.add(h);
	}

	// Return the list of homes and print it to console
	public List<Home> printFoundHomes(List<GeneralCheckBy> specification) {
		
		StringBuilder specList = new StringBuilder();
		for(GeneralCheckBy spec : specification)
			specList.append(spec.toString());
		listOfFoundHomesToPrint = stringOfListOfFoundHomes(specList.toString());
		send(listOfFoundHomesToPrint);
		LOGGER.info(listOfFoundHomesToPrint);
		List <Home> tmp = new ArrayList<Home>(foundHomes);
		this.foundHomes.clear();
		this.combinational = false;
		return (tmp);
		
	}

	private String stringOfListOfFoundHomes(String spec) {
		
		StringBuilder listOfFoundHomes = new StringBuilder();
		listOfFoundHomes.append("\n" + spec + "\n");
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

	// Search all
	public void searchAll(List<GeneralCheckBy> chkByList) {
		for(GeneralCheckBy chk : chkByList)
			searchBySpec(chk);
	}

	// Search by general specification
	private void searchBySpec(GeneralCheckBy specification) {
		if(this.combinational) {
			for(Home h : homes)
				if(!specification.isMatched(h))
					foundHomes.remove(h);
		} else
			for(Home h : homes)
				if(specification.isMatched(h))
					foundHomes.add(h);
		this.combinational = true;
	}

}
