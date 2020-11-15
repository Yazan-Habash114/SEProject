package product.app;

import java.util.ArrayList;
import java.util.Map;

public class SpecToSeachByObject {
	
	private ArrayList <GeneralCheckBy> gcb; 
	private SearchHomes sh = SearchHomes.singletonSearchHomes();
	
	// Constructor
	public SpecToSeachByObject() {
		gcb = new ArrayList<GeneralCheckBy>();
	}
	public void convertToObject(Map<String, Object> specMap) {
		if(specMap.get("Placement") != null)
			gcb.add(new ByPlacement(specMap.get("Placement").toString()));
		
		else if(specMap.get("Type") != null)
			gcb.add(new ByType(specMap.get("Type").toString()));
		
		else if(specMap.get("Material") != null)
			gcb.add(new ByMaterial(specMap.get("Material").toString()));
		
		else if(specMap.get("Pricebelow") != null)
			gcb.add(new ByPriceBelow(Integer.parseInt((String)specMap.get("Pricebelow"))));
		
		else if(specMap.get("Pricebetween") != null) { 
			Integer[] tmp = (Integer[])(specMap.get("Pricebetween"));
			gcb.add(new ByPriceBetween(tmp[0].intValue(),tmp[1].intValue()));
		}
		
		else if(specMap.get("Areabelow") != null)
			gcb.add(new ByAreaBelow(Integer.parseInt((String)specMap.get("Areabelow"))));
		
		else if(specMap.get("Areabetween") != null) { 
			Integer[] tmp = (Integer[])(specMap.get("Areabetween"));
			gcb.add(new ByAreaBetween(tmp[0].intValue(),tmp[1].intValue()));
		}
		
		else if(specMap.get("Bedrooms") != null)
			gcb.add(new ByNumBedrooms(Integer.parseInt((String)specMap.get("Bedrooms"))));
		
		else if(specMap.get("Bathrooms") != null)
			gcb.add(new ByNumBathrooms(Integer.parseInt((String)specMap.get("Bathrooms"))));
		
		else if(specMap.get("AllowingPets") != null)
			gcb.add(new ByPets(specMap.get("AllowingPets").toString()));
		
		else if(specMap.get("LeaseLength") != null)
			gcb.add(new ByLeaseLength(Integer.parseInt((String)specMap.get("LeaseLength"))));
			
		else if(specMap.get("Amenities") != null)
			gcb.add(new ByAmenities(specMap.get("Amenities").toString()));
			
		sh.searchAll(gcb);
		gcb.clear();
	}
	
	

}
