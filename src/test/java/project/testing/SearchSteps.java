package project.testing;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import product.app.SearchHomes;

public class SearchSteps {
	
	private SearchHomes sh;
	
	public SearchSteps() {
		sh = new SearchHomes();
	}
	
	// Scenario (1)
	
	@Given("these homes are contained in the system")
	public void theseHomesAreContainedInTheSystem(io.cucumber.datatable.DataTable dataTable) {
	    sh.appendHome();
	}
	
	
	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String string) {
	    sh.searchBy(string);
	}
	
		
	//scenario 1 
	@Then("A list of homes that match the placment specification should be returned and printed on the console")
	public void aListOfHomesThatMatchThePlacmentSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 2
	@Then("A list of homes that match the  Material specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 3
	@Then("A list of homes that are below a specified price should be returned and printed on the console")
	public void aListOfHomesThatAreBelowASpecifiedPriceShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 4
	@Then("A list of homes that are in the price range should be returned and printed on the console")
	public void aListOfHomesThatAreInThePriceRangeShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 5
	@Then("A list of homes that below a specified area should be returned and printed on the console")
	public void aListOfHomesThatBelowASpecifiedAreaShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 6
	@Then("A list of homes that in the Area range should be returned and printed on the console")
	public void aListOfHomesThatInTheAreaRangeShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 7
	@Then("A list of homes that match the Number of bedrooms should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBedroomsShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 8
	@Then("A list of homes that match the Number of bathrooms should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBathroomsShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 9
	@Then("A list of homes that are Allowing pets should be returned and printed on the console")
	public void aListOfHomesThatAreAllowingPetsShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 10
	@Then("A list of homes that match the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 11
	@Then("A list of homes that match the lease length period should be returned and printed on the console")
	public void aListOfHomesThatMatchTheLeaseLengthPeriodShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//scenario 12
	@Then("A list of homes that provid the Amenities specified should be returned and printed on the console")
	public void aListOfHomesThatProvidTheAmenitiesSpecifiedShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
}
