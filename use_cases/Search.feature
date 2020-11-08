Feature: Search about suitable home

  Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenities-price-area-bedrooms-bathrooms-leaselength)
    Given these homes are contained in the system
      | HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR                                    | 510_150_3_2_6  |
      | APARTMENT_BRICK_CITY_NO_ELEVATOR                                                          | 330_120_4_2_12 |
      | HOUSE_WOOD_CITY_YES_AIRCONDITIONING,BALCONY,ELEVATOR,GARAGEPARKING,FIREPLACE,SWIMMINGPOOL | 150_230_3_1_12 |

  @scenario1
  Scenario: search home by Placement
    When I search about home by Placement "CITY"
    Then A list of homes that match the placement "CITY" specification should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario2
  Scenario: search home by Material
    When I search about home by Material "BRICK"
    Then A list of homes that match the  Material specification "BRICK" should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario3
  Scenario: below specific price/ month
    When I search about home by Price below 400
    Then A list of homes that are below a specified price 400 should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario4
  Scenario: between range of prices/ month
    When I search about home by Between range 300 500
    Then A list of homes that are in the price range 300 500 should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario5
  Scenario: By below specific area/ meter square
    When I search about home by Below specific area 135
    Then A list of homes that below a specified area 135 should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario6
  Scenario: By between range of Areas/ meter square
    When I search about home by Between range of Areas 135 155
    Then A list of homes that in the Area range 135-155 should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario7
  Scenario: Number of bedrooms
    When I search about home by Number of bedrooms 3
    Then A list of homes that match the Number of bedrooms 3 should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario8
  Scenario: Number of bathrooms
    When I search about home by Number of bathrooms 2
    Then A list of homes that match the Number of bathrooms 2 should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario9
  Scenario: Allowing pets
    When I search about home by Allowing pets "YES"
    Then A list of homes that are Allowing pets "YES" should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario10
  Scenario: type
    When I search about home by Type "HOUSE"
    Then A list of homes that match the type "HOUSE" specification should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario11
  Scenario: Lease Length
    When I search about home by Lease Length 12
    Then A list of homes that match the lease length period 12 should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario12
  Scenario: Amenities
    When I search about home by Amenities "AIRCONDITIONING,BALCONY,ELEVATOR,GARAGEPARKING,FIREPLACE,SWIMMINGPOOL" 
    Then A list of homes that provide the Amenities "AIRCONDITIONING,BALCONY,ELEVATOR,GARAGEPARKING,FIREPLACE,SWIMMINGPOOL" specified should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 

  @scenario13
  Scenario: mixing more than one feature
    When I search about home by Amenities "AIRCONDITIONING,BALCONY,ELEVATOR" 
    And I search about home by Lease Length 12
    And I search about home by Placement "CITY"
    Then A list of homes that provide the Amenities "AIRCONDITIONING,BALCONY,ELEVATOR" and match the lease length period 12 and placed in a "CITY" should be returned and printed on the console
    And send an email with the list of found homes to "yazanalhabash5@gmail.com" 
