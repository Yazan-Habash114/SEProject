Feature: Search about suitable home

  Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
    Given these homes are contained in the system
      |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
      |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|

  @scenario1
  Scenario: search home by Placement
    When I search about home by "Placement_CITY" 
    Then A list of homes that match the placment specification should be returned and printed on the console

  @scenario2
  Scenario: search home by Material
    When I search about home by "Material_BRICK" 
    Then A list of homes that match the  Material specification should be returned and printed on the console

  @scenario3
  Scenario: below specific price/ month
    When I search about home by "Price below_400" 
    Then A list of homes that are below a specified price should be returned and printed on the console

  @scenario4
  Scenario: between range of prices/ month
    When I search about home by "Between range_500,300" 
    Then A list of homes that are in the price range should be returned and printed on the console

  @scenario5
  Scenario: By below specific area/ meter square
    When I search about home by "below specific area_135" 
    Then A list of homes that below a specified area should be returned and printed on the console

  @scenario6
  Scenario: By between range of Areas/ meter square
    When I search about home by "between range of Areas_135,155" 
    Then A list of homes that in the Area range should be returned and printed on the console

  @scenario7
  Scenario: Number of bedrooms
    When I search about home by "Number of bedrooms_3" 
    Then A list of homes that match the Number of bedrooms should be returned and printed on the console

  @scenario8
  Scenario: Number of bathrooms
    When I search about home by "Number of bathrooms_2" 
    Then A list of homes that match the Number of bathrooms should be returned and printed on the console

  @scenario9
  Scenario: Allowing pets
    When I search about home by "Allowing pets_YES" 
    Then A list of homes that are Allowing pets should be returned and printed on the console

  @scenario10
  Scenario: type
    When I search about home by "Type_HOUSE" 
    Then A list of homes that match the  type specification should be returned and printed on the console

  @scenario11
  Scenario: Lease Length
    When I search about home by "Lease Length_LONG TERM" 
    Then A list of homes that match the lease length period should be returned and printed on the console

  @scenario12
  Scenario: Amenities
    When I search about home by "Amenities_AIRCONDITIONG, BALCONY, ELEVATOR" 
    Then A list of homes that provid the Amenities specified should be returned and printed on the console