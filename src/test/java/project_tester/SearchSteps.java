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
	}
	
	
	@When("I search about home by {string}")
	public void iSearchAboutHomeBy(String string) {
	    sh.searchBy(string);
	}
	
	
	@Then("A list of homes that matches the  type specification should be returned and printed on the console")
	public void aListOfHomesThatMatchesTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole() {
	    sh.printFoundHomes();
	}

}
