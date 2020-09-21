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
	
	
	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	    sh.printFoundHomes();
	}
	
	// Scenario (2)
	
	@When("I search about home with price less than {int}")
	public void iSearchAboutHomeWithPriceLessThan(Integer int1) {
	    
	}
	
	@Then("A list of homes that matches the price specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesThePriceSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	    
	}
	
	
}
