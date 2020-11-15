package project.testing;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import product.app.*;

public class SearchSteps {

	private SpecToSeachByObject stsbo;
	private SearchHomes sh;
	private Map<String, String> data;
	private Map<String, Object> specMap;
	private List<Home> tmp;
	private boolean checkTrue = true;
	private ArrayList<GeneralCheckBy> specification;
	private MockHolder mh;

	public SearchSteps(MockHolder mh, SpecToSeachByObject stsbo, SearchHomes sh) {
		this.mh = mh;
		this.stsbo = stsbo;
		this.sh = sh;
		this.sh = SearchHomes.singletonSearchHomes();
		this.specMap = new HashMap<String, Object>();
		this.specification = new ArrayList<GeneralCheckBy>();
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
		specMap.put("Placement", placement);
		sendToSearch();
	}

	// Scenario 2
	@When("I search about home by Material {string}")
	public void iSearchAboutHomeByMaterial(String material) {
		specMap.put("Material", material);
		sendToSearch();
	}

	// Scenario 3
	@When("I search about home by Price below {int}")
	public void iSearchAboutHomeByPriceBelow(Integer price) {
		specMap.put("Pricebelow", price.toString());
		sendToSearch();
	}

	// Scenario 4
	@When("I search about home by Between range {int} {int}")
	public void iSearchAboutHomeByBetweenRange(Integer low, Integer high) {
		specMap.put("Pricebetween", new Integer[] { low, high });
		sendToSearch();
	}

	// Scenario 5
	@When("I search about home by Below specific area {int}")
	public void iSearchAboutHomeByBelowSpecificArea(Integer area) {
		specMap.put("Areabelow", area.toString());
		sendToSearch();
	}

	// Scenario 6
	@When("I search about home by Between range of Areas {int} {int}")
	public void iSearchAboutHomeByBetweenRangeOfAreas(Integer low, Integer high) {
		specMap.put("Areabetween", new Integer[] { low, high });
		sendToSearch();
	}

	// Scenario 7
	@When("I search about home by Number of bedrooms {int}")
	public void iSearchAboutHomeByNumberOfBedrooms(Integer bedrooms) {
		specMap.put("Bedrooms", bedrooms.toString());
		sendToSearch();
	}

	// Scenario 8
	@When("I search about home by Number of bathrooms {int}")
	public void iSearchAboutHomeByNumberOfBathrooms(Integer bathrooms) {
		specMap.put("Bathrooms", bathrooms.toString());
		sendToSearch();
	}

	// Scenario 9
	@When("I search about home by Allowing pets {string}")
	public void iSearchAboutHomeByAllowingPets(String isAllowed) {
		specMap.put("AllowingPets", isAllowed);
		sendToSearch();
	}

	// Scenario 10
	@When("I search about home by Type {string}")
	public void iSearchAboutHomeByType(String type) {
		specMap.put("Type", type);
		sendToSearch();
	}

	// Scenario 11
	@When("I search about home by Lease Length {int}")
	public void iSearchAboutHomeByLeaseLength(Integer leaseLength) {
		specMap.put("LeaseLength", leaseLength.toString());
		sendToSearch();
	}

	// Scenario 12
	@When("I search about home by Amenities {string}")
	public void iSearchAboutHomeByAmenities(String amenities) {
		specMap.put("Amenities", amenities);
		sendToSearch();
	}

	// Scenario 13
	@When("I search about home by {string}  {string} and I search about home by {string} {int} and I search about home by {string}  {string} I search about home by {string}  {string}")
	public void iSearchAboutHomeByAndISearchAboutHomeByAndISearchAboutHomeByISearchAboutHomeByAllowingPets(
			String string, String string2, String string3, Integer int1, String string4, String string5, String string6,
			String string7) {
		specMap.put(string, string2);
		specMap.put(string3, int1.toString());
		specMap.put(string4, string5);
		specMap.put(string6, string7);
		sendToSearch();
	}

	private void sendToSearch() {
		stsbo.convertToObject(specMap);
		specMap.clear();
	}

	// *************************************************** Then
	// ***************************************************

	// General list of homes
	public void generalListOfHomesThatMatch(int lengthOfList) {
		tmp = sh.printFoundHomes(specification);
		if (!tmp.isEmpty()) {
			for (GeneralCheckBy gcb : specification)
				for (Home h : tmp)
					if (!gcb.isMatched(h))
						checkTrue = false;
			assertTrue(checkTrue && (tmp.size() == lengthOfList));
		}
	}

	// Scenario 1
	@Then("A list of homes that match the placement {string} specification should be returned and printed on the console")
	public void aListOfHomesThatMatchThePlacmentSpecificationShouldBeReturnedAndPrintedOnTheConsole(String placement) {
		System.out.println("OTHMAN S OTHMAN && YAZAN N HABASH");
		specification.add(new ByPlacement(placement));
		generalListOfHomesThatMatch(2);
	}

	// Scenario 2
	@Then("A list of homes that match the  Material specification {string} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheMaterialSpecificationShouldBeReturnedAndPrintedOnTheConsole(String material) {
		specification.add(new ByMaterial(material));
		generalListOfHomesThatMatch(1);
	}

	// Scenario 3
	@Then("A list of homes that are below a specified price {int} should be returned and printed on the console")
	public void aListOfHomesThatAreBelowASpecifiedPriceShouldBeReturnedAndPrintedOnTheConsole(int price) {
		specification.add(new ByPriceBelow(price));
		generalListOfHomesThatMatch(2);
	}

	// Scenario 4
	@Then("A list of homes that are in the price range {int} {int} should be returned and printed on the console")
	public void aListOfHomesThatAreInThePriceRangeShouldBeReturnedAndPrintedOnTheConsole(Integer low, Integer high) {
		specification.add(new ByPriceBetween(low, high));
		generalListOfHomesThatMatch(1);
	}

	// Scenario 5
	@Then("A list of homes that below a specified area {int} should be returned and printed on the console")
	public void aListOfHomesThatBelowASpecifiedAreaShouldBeReturnedAndPrintedOnTheConsole(int area) {
		specification.add(new ByAreaBelow(area));
		generalListOfHomesThatMatch(1);
	}

	// Scenario 6
	@Then("A list of homes that in the Area range {int}-{int} should be returned and printed on the console")
	public void aListOfHomesThatInTheAreaRangeShouldBeReturnedAndPrintedOnTheConsole(Integer low, Integer high) {
		specification.add(new ByAreaBetween(low, high));
		generalListOfHomesThatMatch(1);
	}

	// Scenario 7
	@Then("A list of homes that match the Number of bedrooms {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBedroomsShouldBeReturnedAndPrintedOnTheConsole(int numOfBedrooms) {
		specification.add(new ByNumBedrooms(numOfBedrooms));
		generalListOfHomesThatMatch(2);
	}

	// Scenario 8
	@Then("A list of homes that match the Number of bathrooms {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheNumberOfBathroomsShouldBeReturnedAndPrintedOnTheConsole(
			Integer numOfBathrooms) {
		specification.add(new ByNumBathrooms(numOfBathrooms));
		generalListOfHomesThatMatch(2);
	}

	// Scenario 9
	@Then("A list of homes that are Allowing pets {string} should be returned and printed on the console")
	public void aListOfHomesThatAreAllowingPetsShouldBeReturnedAndPrintedOnTheConsole(String allowingPets) {
		specification.add(new ByPets(allowingPets));
		generalListOfHomesThatMatch(1);
	}

	// Scenario 10
	@Then("A list of homes that match the type {string} specification should be returned and printed on the console")
	public void aListOfHomesThatMatchTheTypeSpecificationShouldBeReturnedAndPrintedOnTheConsole(String type) {
		specification.add(new ByType(type));
		generalListOfHomesThatMatch(2);
	}

	// Scenario 11
	@Then("A list of homes that match the lease length period {int} should be returned and printed on the console")
	public void aListOfHomesThatMatchTheLeaseLengthPeriodShouldBeReturnedAndPrintedOnTheConsole(Integer length) {
		specification.add(new ByLeaseLength(length));
		generalListOfHomesThatMatch(2);
	}

	// Scenario 12
	@Then("A list of homes that provide the Amenities {string} specified should be returned and printed on the console")
	public void aListOfHomesThatProvidTheAmenitiesSpecifiedShouldBeReturnedAndPrintedOnTheConsole(String amenities) {
		specification.add(new ByAmenities(amenities));
		generalListOfHomesThatMatch(1);
	}

	// Scenario 13

	@Then("A list of homes that provide the Amenities {string} and match the lease length period {int} and placed in a {string} and allowing pets {string} should be returned and printed on the console")
	public void aListOfHomesThatProvideTheAmenitiesAndMatchTheLeaseLengthPeriodAndPlacedInAAndAllowingPetsShouldBeReturnedAndPrintedOnTheConsole(
			String string, Integer int1, String string2, String string3) {
		specification.add(new ByAmenities(string));
		specification.add(new ByLeaseLength(int1));
		specification.add(new ByPlacement(string2));
		specification.add(new ByPets(string3));
		generalListOfHomesThatMatch(1);
	}

	@And("send an email with the list of found homes to {string}")
	public void sendAnEmailWithListOfHomesFoundTo(String email) {
		// Verifying
		verify(mh.getService(), times(1)).sendEmail(email, sh.getListOfFoundHomesToPrint());
	}
}
