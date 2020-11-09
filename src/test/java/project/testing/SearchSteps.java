package project.testing;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import product.app.*;

public class SearchSteps {

	private SearchHomes sh;
	private Map<String, String> data;
	private List<Home> tmp;
	private boolean checkTrue = true;
	private GeneralCheckBy specification;
	private MockHolder mh;

	public SearchSteps(MockHolder mh, SearchHomes sh) {
		this.mh = mh;
		this.sh = sh;
	}

	@Given("these homes are contained in the system")
	public void theseHomesAreContainedInTheSystem(DataTable tb) {
		data = tb.asMap(String.class, String.class);
		String[] list = new String[10]; // Saving all specifications
		for (Map.Entry<String, String> entry : this.data.entrySet()) {
			System.arraycopy(entry.getKey().split("_"), 0, list, 0, 5);
			System.arraycopy(entry.getValue().split("_"), 0, list, 5, 5);
			sh.storeHome(list);
		}
	}

	// Scenario 1
	@When("I search about home by Placement {string}")
	public void iSearchAboutHomeByPlacement(String placement) {
		sh.searchByPlacement(placement);
	}

	// Scenario 2
	@When("I search about home by Material {string}")
	public void iSearchAboutHomeByMaterial(String material) {
		sh.searchByMaterial(material);
	}

	// Scenario 3
	@When("I search about home by Price below {int}")
	public void iSearchAboutHomeByPriceBelow(Integer price) {
		sh.searchByPriceBelow(price.intValue());
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
	public void iSearchAboutHomeByNumberOfBedrooms(Integer bedrooms) {
		sh.searchByNumberOfBedrooms(bedrooms.intValue());
	}

	// Scenario 8
	@When("I search about home by Number of bathrooms {int}")
	public void iSearchAboutHomeByNumberOfBathrooms(Integer bathrooms) {
		sh.searchByNumberOfBathrooms(bathrooms.intValue());
	}

	// Scenario 9
	@When("I search about home by Allowing pets {string}")
	public void iSearchAboutHomeByAllowingPets(String isAllowed) {
		sh.searchByAllowingPets(isAllowed);
	}

	// Scenario 10
	@When("I search about home by Type {string}")
	public void iSearchAboutHomeByType(String type) {
		sh.searchByType(type);
	}

	// Scenario 11
	@When("I search about home by Lease Length {int}")
	public void iSearchAboutHomeByLeaseLength(Integer leaseLength) {
		sh.searchByLeaseLength(leaseLength.intValue());
	}

	// Scenario 12
	@When("I search about home by Amenities {string}")
	public void iSearchAboutHomeByAmenities(String amenities) {
		sh.searchByAmenities(amenities);
	}

	// *************************************************** Then
	// **************************************************

	// General list of homes
	public void generalListOfHomesThatMatch(int lengthOfList) {
		tmp = sh.printFoundHomes(specification);
		if (!tmp.isEmpty()) {
			for (Home h : tmp)
				if (!specification.isMatched(h))
					checkTrue = false;
			assertTrue(checkTrue && (tmp.size() == lengthOfList));
		}
	}

	// Scenario 1
	@Then("A list of homes that match the placement {string} specification should be returned and printed on the console")
	public void aListOfHomesThatMatchThePlacmentSpecificationShouldBeReturnedAndPrintedOnTheConsole(String placement) {
		System.out.println("OTHMAN S OTHMAN && YAZAN N HABASH");
		specification = new ByPlacement(placement);
		generalListOfHomesThatMatch(2);
	}

	// Scenario 2
	@Then("A list of homes that match the  Material specification {string} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole(String material) {
		specification = new ByMaterial(material);
		generalListOfHomesThatMatch(1);
	}

	// Scenario 3
	@Then("A list of homes that are below a specified price {int} should be returned and printed on the console")
	public void aListOfHomesThatAreBelowASpecifiedPriceShouldBeReturnedAndPrintedOnTheConsole(int price) {
		specification = new ByPriceBelow(price);
		generalListOfHomesThatMatch(2);
	}

	// Scenario 4
	@Then("A list of homes that are in the price range {int} {int} should be returned and printed on the console")
	public void aListOfHomesThatAreInThePriceRangeShouldBeReturnedAndPrintedOnTheConsole(Integer low, Integer high) {
		specification = new ByPriceBetween(low, high);
		generalListOfHomesThatMatch(1);
	}

	// Scenario 5
	@Then("A list of homes that below a specified area {int} should be returned and printed on the console")
	public void aListOfHomesThatBelowASpecifiedAreaShouldBeReturnedAndPrintedOnTheConsole(int area) {
		specification = new ByAreaBelow(area);
		generalListOfHomesThatMatch(1);
	}

	// Scenario 6
	@Then("A list of homes that in the Area range {int}-{int} should be returned and printed on the console")
	public void aListOfHomesThatInTheAreaRangeShouldBeReturnedAndPrintedOnTheConsole(Integer low, Integer high) {
		specification = new ByAreaBetween(low, high);
		generalListOfHomesThatMatch(1);
	}

	// Scenario 7
	@Then("A list of homes that match the Number of bedrooms {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBedroomsShouldBeReturnedAndPrintedOnTheConsole(int numOfBedrooms) {
		specification = new ByNumBedrooms(numOfBedrooms);
		generalListOfHomesThatMatch(2);
	}

	// Scenario 8
	@Then("A list of homes that match the Number of bathrooms {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBathroomsShouldBeReturnedAndPrintedOnTheConsole(Integer numOfBathrooms) {
		specification = new ByNumBathrooms(numOfBathrooms);
		generalListOfHomesThatMatch(2);
	}

	// Scenario 9
	@Then("A list of homes that are Allowing pets {string} should be returned and printed on the console")
	public void aListOfHomesThatAreAllowingPetsShouldBeReturnedAndPrintedOnTheConsole(String allowingPets) {
		specification = new ByPets(allowingPets);
		generalListOfHomesThatMatch(1);
	}

	// Scenario 10
	@Then("A list of homes that match the type {string} specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole(String type) {
		specification = new ByType(type);
		generalListOfHomesThatMatch(2);
	}

	// Scenario 11
	@Then("A list of homes that match the lease length period {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheLeaseLengthPeriodShouldBeReturnedAndPrintedOnTheConsole(Integer length) {
		specification = new ByLeaseLength(length);
		generalListOfHomesThatMatch(2);
	}

	// Scenario 12
	@Then("A list of homes that provide the Amenities {string} specified should be returned and printed on the console")
	public void aListOfHomesThatProvidTheAmenitiesSpecifiedShouldBeReturnedAndPrintedOnTheConsole(String amenities) {
		specification = new ByAmenities(amenities);
		generalListOfHomesThatMatch(1);
	}

	// Scenario 13
	@Then("A list of homes that provide the Amenities {string} and match the lease length period {int} and placed in a {string} should be returned and printed on the console")
	public void aListOfHomesThatProvideTheAmenitiesAIRCONDITIONINGBALCONYELEVATORAndMatchesTheLeaseLengthPeriodAndPlacedInAShouldBeReturnedAndPrintedOnTheConsole(
			String amenities, Integer leaseLength, String placement) {

		System.out.println("\nList of homes that provide the amenities '" + amenities + "' and match the lease length period = ("
						+ leaseLength + ") months and placed in a '" + placement + "' :");
		specification = new ByAmenities(amenities);
		generalListOfHomesThatMatch(1);
	}
	
	@And("send an email with the list of found homes to {string}")
	public void sendAnEmailWithListOfHomesFoundTo(String email) {
		// Verifying
		verify(mh.getService(), times(1)).sendEmail(email, sh.getListOfFoundHomesToPrint());
	}
}
