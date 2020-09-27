Feature: Search about suitable home

  Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenities-price-area-bedrooms-bathrooms-leaselength)
    Given these homes are contained in the system
      |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
      |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|
      |HOUSE_WOOD_VILLAGE_YES_SWIMMINGPOOL|150_230_3_1_6|
      |HOUSE_STONE_CITY_YES_ELEVATOR,SWIMMINGPOOL,FIREPLACE,GARAGEPARKING|720_400_4_3_12|
      |APARTMENT_STONE_CITY_NO_BALCONY|110_90_2_1_6|
      |APARTMENT_BRICK_CITY_NO_BALCONY,ELEVATOR|300_128_3_2_6|
      |HOUSE_WOOD_CITY_YES_FIREPLACE,BALCONY,SWIMMINGPOOL,GARAGEPARKING|900_235_4_2_12|
      |HOUSE_STONE_VILLAGE_YES_SWIMMINGPOOL,GARAGEPARKING,AIRCONDITIONING|250_260_3_3_6|
      |APARTMENT_BRICK_VILLAGE_NO_AIRCONDITIONING|120_70_2_1_12|
      |HOUSE_STONE_VILLAGE_NO_AIRCONDITIONING,ELEVATOR,SWIMMINGPOOL,FIREPLACE|280_180_3_2_6|
      |HOUSE_WOOD_VILLAGE_YES_AIRCONDITIONING,FIREPLACE,SWIMMINGPOOL|300_200_4_3_12|
      |APARTMENT_BRICK_CITY_NO_ELEVATOR,FIREPLACE,GARAGEPARKING|260_130_2_2_12|
      |APARTMENT_STONE_CITY_NO_AIRCONDITIONING,BALCONY,ELEVATOR|370_290_2_2_12|
      |APARTMENT_BRICK_CITY_YES_AIRCONDITIONING,ELEVATOR|124_50_3_1_6|
      |HOUSE_STONE_VILLAGE_YES_AIRCONDITIONING,ELEVATOR,SWIMMINGPOOL|300_195_4_3_12|
      |HOUSE_WOOD_VILLAGE_NO_AIRCONDITIONING,ELEVATOR,FIREPLACE,SWIMMINGPOOL|670_178_2_2_6|
      |APARTMENT_STONE_CITY_YES_ELEVATOR,FIREPLACE,GARAGEPARKING,BALCONY|470_210_4_2_12|
      |APARTMENT_STONR_CITY_NO_BALCONY|140_93_1_1_12|
      |HOUSE_BRICK_VILLAGE_YES_BALCONY,GARAGEPARKING,AIRCONDITIONING|453_145_5_3_6|
      |HOUSE_WOOD_VILLAGE_NO_ELEVATOR,AIRCONDITIONING,BALCONY,FIREPLACE|560_264_4_2_6|
      |APARTMENT_STONE_VILLAGE_NO_ELEVATOR,GARAGEPARKING|280_124_3_2_12|
      |APARTMENT_BRICK_CITY_YES_ELEVATOR,GARAGEPARKING,FIREPLACE|310_149_3_2_12|
      |HOUSE_WOOD_CITY_YES_ELEVATOR,GARAGEPARKING,AIRCONDITIONING|260_137_3_2_6|
      |HOUSE_BRICK_VILLAGE_NO_ELEVATOR,GARAGEPARKING,FIREPLACE,BALCONY|340_174_4_2_12|
      |HOUSE_STONE_CITY_YES_ELEVATOR,SWIMMINGPOOL,AIRCONDITIONING,FIREPLACE|660_312_5_3_12|
      
      
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
    When I search about home by "Between range_300,500" 
    Then A list of homes that are in the price range should be returned and printed on the console

  @scenario5
  Scenario: By below specific area/ meter square
    When I search about home by "Below specific area_135" 
    Then A list of homes that below a specified area should be returned and printed on the console

  @scenario6
  Scenario: By between range of Areas/ meter square
    When I search about home by Between range of Areas "135,155" 
    Then A list of homes that in the Area range should be returned and printed on the console

  @scenario7
  Scenario: Number of bedrooms
    When I search about home by Number of bedrooms "3" 
    Then A list of homes that match the Number of bedrooms should be returned and printed on the console

  @scenario8
  Scenario: Number of bathrooms
    When I search about home by Number of bathrooms "2" 
    Then A list of homes that match the Number of bathrooms should be returned and printed on the console

  @scenario9
  Scenario: Allowing pets
    When I search about home by Allowing pets "YES" 
    Then A list of homes that are Allowing pets should be returned and printed on the console

  @scenario10
  Scenario: type
    When I search about home by Type "HOUSE" 
    Then A list of homes that match the  type specification should be returned and printed on the console

  @scenario11
  Scenario: Lease Length
    When I search about home by Lease Length "12" 
    Then A list of homes that match the lease length period should be returned and printed on the console

  @scenario12
  Scenario: Amenities
    When I search about home by Amenities "AIRCONDITIONING,BALCONY,ELEVATOR" 
    Then A list of homes that provid the Amenities specified should be returned and printed on the console
    
  @scenario13
  Scenario: mixing more than one feature 
    When I search about home by Amenities "AIRCONDITIONING,BALCONY,ELEVATOR" 
    And I search about home by Lease Length "12" 
    And I search about home by Placement "CITY" 
    Then A list of homes that provid the Amenities specified should be returned and printed on the console 
  