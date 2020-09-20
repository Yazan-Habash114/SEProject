package project_tester;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import search_feature.SearchHomes;

public class SearchSteps {
	
	SearchHomes sh;
	
	SearchSteps() {
		sh = new SearchHomes();
	}
	
	@Given("these homes are contained in the system")
	public void theseHomesAreContainedInTheSystem(io.cucumber.datatable.DataTable dataTable) {
	    
	    sh.appendHome();
	    return;
	}
	

	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
