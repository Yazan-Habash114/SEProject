package project.testing;

import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import product.app.SearchHomes;

public class SearchSteps {
	
	private SearchHomes sh;
	private Map <String, String> data;
	
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
	    sh.searchBetweenRangeOfAreas(low.intValue(), high.intValue());
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
	
	
	//scenario 1 
	@Then("A list of homes that match the placment specification should be returned and printed on the console")
	public void aListOfHomesThatMatchThePlacmentSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 2
	@Then("A list of homes that match the  Material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 3
	@Then("A list of homes that are below a specified price should be returned and printed on the console")
	public void aListOfHomesThatAreBelowASpecifiedPriceShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 4
	@Then("A list of homes that are in the price range should be returned and printed on the console")
	public void aListOfHomesThatAreInThePriceRangeShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 5
	@Then("A list of homes that below a specified area should be returned and printed on the console")
	public void aListOfHomesThatBelowASpecifiedAreaShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 6
	@Then("A list of homes that in the Area range should be returned and printed on the console")
	public void aListOfHomesThatInTheAreaRangeShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 7
	@Then("A list of homes that match the Number of bedrooms should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBedroomsShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 8
	@Then("A list of homes that match the Number of bathrooms should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBathroomsShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 9
	@Then("A list of homes that are Allowing pets should be returned and printed on the console")
	public void aListOfHomesThatAreAllowingPetsShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 10
	@Then("A list of homes that match the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 11
	@Then("A list of homes that match the lease length period should be returned and printed on the console")
	public void aListOfHomesThatMatchTheLeaseLengthPeriodShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
	
	//scenario 12
	@Then("A list of homes that provid the Amenities specified should be returned and printed on the console")
	public void aListOfHomesThatProvidTheAmenitiesSpecifiedShouldBeReturnedAndPrintedOnTheConsole() {
		sh.printFoundHomes();
	    return;
	}
	
}
