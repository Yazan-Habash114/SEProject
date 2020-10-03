package project.testing;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import product.app.Home;
import product.app.SearchHomes;

public class SearchSteps {
	
	private SearchHomes sh;
	private Map <String, String> data;
	private ArrayList <Home> tmp;
	private boolean checktrue = true;
	
	
	public SearchSteps() {
		sh = new SearchHomes();
	}
	
	@Given("these homes are contained in the system")
	public void theseHomesAreContainedInTheSystem(DataTable tb) {
		data = tb.asMap(String.class, String.class);
		String[] list = new String [10]; // Saving all specifications
		for(Map.Entry<String, String> entry : this.data.entrySet()) {
			System.arraycopy(entry.getKey().split("_"), 0, list, 0, 5);
			System.arraycopy(entry.getValue().split("_"), 0, list, 5, 5);
			sh.storeHome(list);
		}
	}

	
	// Scenario 1
	@When("I search about home by Placement {string}")
	public void iSearchAboutHomeByPlacement(String string) {
	    sh.searchByPlacement(string);
	}
	
	
	// Scenario 2
	@When("I search about home by Material {string}")
	public void iSearchAboutHomeByMaterial(String string) {
		sh.searchByMaterial(string);
	}
	
	
	// Scenario 3
	@When("I search about home by Price below {int}")
	public void iSearchAboutHomeByPriceBelow(Integer value) {
		sh.searchByPriceBelow(value.intValue());
	}
	
	
	// Scenario 4
	@When("I search about home by Between range {int} {int}")
	public void iSearchAboutHomeByBetweenRange(Integer low, Integer high) {
		sh.searchByPriceBetweenRange(low.intValue(), high.intValue());
	}
	
	
	// Scenario 5
	@When("I search about home by Below specific area {int}")
	public void iSearchAboutHomeByBelowSpecificArea(Integer area) {
		sh.searchByAreaBelow(area.intValue());
	}
	
	
	// Scenario 6
	@When("I search about home by Between range of Areas {int} {int}")
	public void iSearchAboutHomeByBetweenRangeOfAreas(Integer low, Integer high) {
		sh.searchBetweenRangeOfAreas(low.intValue(), high.intValue());
	}
	
	
	// Scenario 7
	@When("I search about home by Number of bedrooms {int}")
	public void iSearchAboutHomeByNumberOfBedrooms(Integer num) {
		sh.searchByNumberOfBedrooms(num.intValue());
	}
	
	
	// Scenario 8
	@When("I search about home by Number of bathrooms {int}")
	public void iSearchAboutHomeByNumberOfBathrooms(Integer num) {
		sh.searchByNumberOfBathrooms(num.intValue());
	}
	
	
	// Scenario 9
	@When("I search about home by Allowing pets {string}")
	public void iSearchAboutHomeByAllowingPets(String value) {
		sh.searchByAllowingPets(value);
	}
	
	
	// Scenario 10
	@When("I search about home by Type {string}")
	public void iSearchAboutHomeByType(String type) {
		sh.searchByType(type);
	}
	
	
	// Scenario 11
	@When("I search about home by Lease Length {int}")
	public void iSearchAboutHomeByLeaseLength(Integer value) {
		sh.searchByLeaseLength(value.intValue());
	}
	
	
	// Scenario 12
	@When("I search about home by Amenities {string}")
	public void iSearchAboutHomeByAmenities(String Amenities) {
		sh.searchByAmenities(Amenities);
	}
	
	
	
	// *************************************************** Then **************************************************
	
	
	
	// Scenario 1 
	@Then("A list of homes that match the placement {string} specification should be returned and printed on the console")
	public void aListOfHomesThatMatchThePlacmentSpecificationShouldBeReturnedAndPrintedOnTheConsole(String placement) {
		System.out.println("OTHMAN S OTHMAN && YAZAN N HABASH");
		System.out.println("List of homes that are placed in a '" + placement + "' :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if (!h.chkPlacement(placement))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==2));
		}
	    return;
	}
	
	
	// Scenario 2
	@Then("A list of homes that match the  Material specification {string} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole(String material) {
		System.out.println("List of homes that match the Material specification '" + material + "' :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkMaterial(material))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==1));
		}
	    return;
	}
	
	
	// Scenario 3
	@Then("A list of homes that are below a specified price {int} should be returned and printed on the console")
	public void aListOfHomesThatAreBelowASpecifiedPriceShouldBeReturnedAndPrintedOnTheConsole(int price) {
		System.out.println("list of homes that are below a specified price '" + price + "' :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkPriceBelow(price))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==2));
		}
	    return;
	}
	
	
	// Scenario 4
	@Then("A list of homes that are in the price range {int} {int} should be returned and printed on the console")
	public void aListOfHomesThatAreInThePriceRangeShouldBeReturnedAndPrintedOnTheConsole(Integer low, Integer high) {
		System.out.println("List of homes that are in the price range (" + low.toString() + ", " + high.toString() + "):");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkPriceInRange(low.intValue(), high.intValue()))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==0));
		}
	    return;
	}
	
	
	// Scenario 5
	@Then("A list of homes that below a specified area {int} should be returned and printed on the console")
	public void aListOfHomesThatBelowASpecifiedAreaShouldBeReturnedAndPrintedOnTheConsole(int area) {
		System.out.println("list of homes that are below a specified area '" + area + " m2' :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkAreaBelow(area))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==1));
		}
	    return;
	}
	
	
	// Scenario 6
	@Then("A list of homes that in the Area range {int}-{int} should be returned and printed on the console")
	public void aListOfHomesThatInTheAreaRangeShouldBeReturnedAndPrintedOnTheConsole(Integer low, Integer high) {
		System.out.println("List of homes that are in the area range (" + low.toString() + ", " + high.toString() + "):");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkAreaInRange(low.intValue(), high.intValue()))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==1));
		}
	    return;
	}
	
	
	// Scenario 7
	@Then("A list of homes that match the Number of bedrooms {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBedroomsShouldBeReturnedAndPrintedOnTheConsole(int numofbedrooms) {
		System.out.println("list of homes that match the Number of bedrooms = " + numofbedrooms + " :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkNumberOfBedrooms(numofbedrooms))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==2));
		}
	    return;
	}
	
	
	
	// Scenario 8
	@Then("A list of homes that match the Number of bathrooms {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBathroomsShouldBeReturnedAndPrintedOnTheConsole(Integer value) {
		System.out.println("List of homes that have number of bathrooms = " + value.intValue() + " :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkNumberOfBathrooms(value))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==2));
		}
	    return;
	}
	
	
	// Scenario 9
	@Then("A list of homes that are Allowing pets {string} should be returned and printed on the console")
	public void aListOfHomesThatAreAllowingPetsShouldBeReturnedAndPrintedOnTheConsole(String allowingpets) {
		System.out.print("list of homes that are ");
		if(allowingpets=="NO") 
			System.out.print("not ");
		System.out.println(" Allowing pets :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkAllowingPets(allowingpets))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==1));
		}
	    return;
	}
	
	
	// Scenario 10
	@Then("A list of homes that match the type {string} specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole(String type) {
		System.out.println("List of homes that match the type '" + type + "' are :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkType(type))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==2));
		}
	    return;
	}
	
	
	// Scenario 11
	@Then("A list of homes that match the lease length period {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheLeaseLengthPeriodShouldBeReturnedAndPrintedOnTheConsole(Integer length) {
		System.out.println("List of homes that have lease length of '" + length.intValue() + "' are :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkLeaseLength(length))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==2));
		}
	    return;
	}
	
	
	// Scenario 12
	@Then("A list of homes that provide the Amenities {string} specified should be returned and printed on the console")
	public void aListOfHomesThatProvidTheAmenitiesSpecifiedShouldBeReturnedAndPrintedOnTheConsole(String amenities) {
		System.out.println("List of homes that have amenites '" + amenities + "' are :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!h.chkAmenities(amenities.split(",")))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==1));
		}
	    return;
	}

	
	// Scenario 13
	@Then("A list of homes that provide the Amenities {string} and match the lease length period {int} and placed in a {string} should be returned and printed on the console")
	public void aListOfHomesThatProvideTheAmenitiesAIRCONDITIONINGBALCONYELEVATORAndMatchesTheLeaseLengthPeriodAndPlacedInAShouldBeReturnedAndPrintedOnTheConsole(String Amenities, Integer leaselength, String placement) {
		System.out.println("list of homes that provide the Amenities '" + Amenities +
				"' and match the lease length period = (" + leaselength + ") months and placed in a '" + placement + "' :");
		tmp = sh.printFoundHomes();
		if(tmp != null) {
			for(Home h: tmp)
				if(!(h.chkAmenities(Amenities.split(",")) && h.chkPlacement(placement) && h.chkLeaseLength(leaselength)))
					checktrue = false;
			assertTrue(checktrue && (tmp.size()==1));
		}
	    return;
	}


}
