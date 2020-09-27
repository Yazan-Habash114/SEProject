package project.testing;

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
	private ArrayList <Home> foundHomes;
	private String category;
	private String value1, value2;
	
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
		this.category = "Placement";
		this.value1 = string;
	    foundHomes = sh.searchByPlacement(string);
	}
	
	
	// Scenario 2
	@When("I search about home by Material {string}")
	public void iSearchAboutHomeByMaterial(String string) {
		this.category = "Material";
		this.value1 = string;
		foundHomes = sh.searchByMaterial(string);
	}
	
	
	// Scenario 3
	@When("I search about home by Price below {int}")
	public void iSearchAboutHomeByPriceBelow(Integer value) {
		this.category = "Price below";
		this.value1 = value.toString();
		foundHomes = sh.searchByPriceBelow(value.intValue());
	}
	
	
	// Scenario 4
	@When("I search about home by Between range {int} {int}")
	public void iSearchAboutHomeByBetweenRange(Integer low, Integer high) {
		this.category = "Price between";
		this.value1 = low.toString();
		this.value2 = high.toString();
		foundHomes = sh.searchByPriceBetweenRange(low.intValue(), high.intValue());
	}
	
	
	// Scenario 5
	@When("I search about home by Below specific area {int}")
	public void iSearchAboutHomeByBelowSpecificArea(Integer area) {
		this.category = "Below specific area";
		this.value1 = area.toString();
		foundHomes = sh.searchByAreaBelow(area.intValue());
	}
	
	
	// Scenario 6
	@When("I search about home by Between range of Areas {int} {int}")
	public void iSearchAboutHomeByBetweenRangeOfAreas(Integer low, Integer high) {
		this.category = "Area between";
		this.value1 = low.toString();
		this.value2 = high.toString();
		foundHomes = sh.searchBetweenRangeOfAreas(low.intValue(), high.intValue());
	}
	
	
	// Scenario 7
	@When("I search about home by Number of bedrooms {int}")
	public void iSearchAboutHomeByNumberOfBedrooms(Integer num) {
		this.category = "Number of bedrooms";
		this.value1 = num.toString();
		foundHomes = sh.searchByNumberOfBedrooms(num.intValue());
	}
	
	
	
	// Scenario 8
	@When("I search about home by Number of bathrooms {int}")
	public void iSearchAboutHomeByNumberOfBathrooms(Integer num) {
		this.category = "Number of bathrooms";
		this.value1 = num.toString();
		foundHomes = sh.searchByNumberOfBathrooms(num.intValue());
	}
	
	
	// Scenario 9
	@When("I search about home by Allowing pets {string}")
	public void iSearchAboutHomeByAllowingPets(String value) {
		this.category = "Allowing pets";
		this.value1 = value.toString();
		foundHomes = sh.searchByAllowingPets(value);
	}
	
	
	// Scenario 10
	@When("I search about home by Type {string}")
	public void iSearchAboutHomeByType(String type) {
		this.category = "Type";
		this.value1 = type;
		foundHomes = sh.searchByType(type);
	}
	
	
	// Scenario 11
	@When("I search about home by Lease Length {int}")
	public void iSearchAboutHomeByLeaseLength(Integer value) {
		this.category = "Lease length";
		this.value1 = value.toString();
		foundHomes = sh.searchByLeaseLength(value.intValue());
	}
	
	
	// Scenario 12
	@When("I search about home by Amenities {string}")
	public void iSearchAboutHomeByAmenities(String Amenities) {
		this.category = "Amenities";
		this.value1 = Amenities;
		foundHomes = sh.searchByAmenities(Amenities);
	}
	
	
	// *************************************************** Then **************************************************
	
	
	//scenario 1 
	@Then("A list of homes that match the placment specification should be returned and printed on the console")
	public void aListOfHomesThatMatchThePlacmentSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 2
	@Then("A list of homes that match the  Material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 3
	@Then("A list of homes that are below a specified price should be returned and printed on the console")
	public void aListOfHomesThatAreBelowASpecifiedPriceShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 4
	@Then("A list of homes that are in the price range should be returned and printed on the console")
	public void aListOfHomesThatAreInThePriceRangeShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + ", " + value2 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + ", " + value2 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 5
	@Then("A list of homes that below a specified area should be returned and printed on the console")
	public void aListOfHomesThatBelowASpecifiedAreaShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 6
	@Then("A list of homes that in the Area range should be returned and printed on the console")
	public void aListOfHomesThatInTheAreaRangeShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + ", " + value2 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + ", " + value2 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 7
	@Then("A list of homes that match the Number of bedrooms should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBedroomsShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 8
	@Then("A list of homes that match the Number of bathrooms should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBathroomsShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 9
	@Then("A list of homes that are Allowing pets should be returned and printed on the console")
	public void aListOfHomesThatAreAllowingPetsShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 10
	@Then("A list of homes that match the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 11
	@Then("A list of homes that match the lease length period should be returned and printed on the console")
	public void aListOfHomesThatMatchTheLeaseLengthPeriodShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have '" + category + "' with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
	
	//scenario 12
	@Then("A list of homes that provide the Amenities specified should be returned and printed on the console")
	public void aListOfHomesThatProvidTheAmenitiesSpecifiedShouldBeReturnedAndPrintedOnTheConsole() {
		if(this.foundHomes.isEmpty())
			System.out.println("There are no homes have '" + category + "' with value '" + value1 + "'.");
		else {
			System.out.println("All homes that have amenites with value '" + value1 + "':");
			sh.printFoundHomes();
		}
	}
	
}
