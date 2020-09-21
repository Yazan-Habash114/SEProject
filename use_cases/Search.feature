Feature: Search about suitable home
  
Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
	Given these homes are contained in the system
                |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
                |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|
               
  @tag1
  Scenario: search home by Placement
      When I search about home by "Placement_City" 
      Then A list of homes that matches the  type specification should be returned and printed on the console
      
  @tag2
  Scenario: search home by Material
      When I search about home by "Material_Brick" 
      Then A list of homes that matches the  Material specification should be returned and printed on the console
  
  
  @tag3
  Scenario: below specific price/ month
      When I search about home by "price below_400" 
      Then A list of homes that matches the  price below specification should be returned and printed on the console
  
  @tag4
  Scenario: between range of prices/ month
      When I search about home by "between range_500,300" 
      Then A list of homes that matches the  between range specification should be returned and printed on the console
  
  @tag5
  Scenario: By below specific area/ meter square
      When I search about home by "By below specific area_135" 
      Then A list of homes that matches the  type specification should be returned and printed on the console
  
  @tag6
  Scenario: By between range of Areas/ meter square
      When I search about home by "By between range of Areas_135,155" 
      Then A list of homes that matches the  between range of Areas specification should be returned and printed on the console
      
  @tag7
  Scenario: Number of bedrooms
      When I search about home by "Number of bedrooms_3" 
      Then A list of homes that matches the  Number of bedrooms specification should be returned and printed on the console
  
  
  @tag8
  Scenario: Number of bathrooms
      When I search about home by "Number of bathrooms_2" 
      Then A list of homes that matches the  Number of bathrooms specification should be returned and printed on the console
   
   
  @tag9
  Scenario: Allowing pets
      When I search about home by "Allowing pets_yes" 
      Then A list of homes that matches the  Allowing pets specification should be returned and printed on the console
  
  
  @tag10
  Scenario: type
      When I search about home by "type_house" 
      Then A list of homes that matches the  type specification should be returned and printed on the console
      
  
  @tag11
  Scenario: Lease Length
      When I search about home by "Lease Length_long term" 
      Then A list of homes that matches the  lease length specification should be returned and printed on the console
  
  
  @tag12
  Scenario: Amenities
      When I search about home by "Amenities_AirConditioning, Balcony, Elevator" 
      Then A list of homes that matches the  Amenities specification should be returned and printed on the console
  
  