package product.app;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SearchHomes {
	private static SearchHomes singletonSearchHomesObject = new SearchHomes();
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

	// Singleton
	public static SearchHomes singletonSearchHomes() {
		if(singletonSearchHomesObject==null) 
			singletonSearchHomesObject=new SearchHomes();
		return singletonSearchHomesObject;
	}

	// Add to database list
	public void storeHome(String[] list) {
		Home h = new Home(list);
		homes.add(h);
	}

	// Return the list of homes and print it to console
	public List<Home> printFoundHomes(ArrayList<GeneralCheckBy> specification) {
		for (GeneralCheckBy spec : specification)
			listOfFoundHomesToPrint = stringOfListOfFoundHomes(spec.toString());
		send(listOfFoundHomesToPrint);
		LOGGER.info(listOfFoundHomesToPrint);
		ArrayList<Home> tmp = foundHomes;
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
	public void SearchAll(ArrayList<GeneralCheckBy> chkByList) {
		for (GeneralCheckBy chk : chkByList) {
			searchBySpec(chk);
			this.combinational = true;
		}
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
	}

}
