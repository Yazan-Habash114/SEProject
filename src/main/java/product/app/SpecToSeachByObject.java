package product.app;

import java.util.ArrayList;
import java.util.Map;

public class SpecToSeachByObject {
	
	private ArrayList <GeneralCheckBy> gcb;
	
	// Constructor
	public SpecToSeachByObject() {
		this.gcb = new ArrayList<GeneralCheckBy>();
	}
	
	public void convertToObject(Map<String, Object> specMap, SearchHomes sh) {
		
		for(Map.Entry <String, Object> entry: specMap.entrySet()) {
			
			if(entry.getKey().equals("Placement"))
				gcb.add(new ByPlacement(specMap.get("Placement").toString()));
			
			else if(entry.getKey().equals("Type"))
				gcb.add(new ByType(specMap.get("Type").toString()));
			
			else if(entry.getKey().equals("Material"))
				gcb.add(new ByMaterial(specMap.get("Material").toString()));
			
			else if(entry.getKey().equals("Pricebelow"))
				gcb.add(new ByPriceBelow(Integer.parseInt((String)specMap.get("Pricebelow"))));
			
			else if(entry.getKey().equals("Pricebetween")) { 
				Integer[] tmp = (Integer[])(specMap.get("Pricebetween"));
				gcb.add(new ByPriceBetween(tmp[0].intValue(),tmp[1].intValue()));
			}
			
			else if(entry.getKey().equals("Areabelow"))
				gcb.add(new ByAreaBelow(Integer.parseInt((String)specMap.get("Areabelow"))));
			
			else if(entry.getKey().equals("Areabetween")) { 
				Integer[] tmp = (Integer[])(specMap.get("Areabetween"));
				gcb.add(new ByAreaBetween(tmp[0].intValue(),tmp[1].intValue()));
			}
			
			else if(entry.getKey().equals("Bedrooms"))
				gcb.add(new ByNumBedrooms(Integer.parseInt((String)specMap.get("Bedrooms"))));
			
			else if(entry.getKey().equals("Bathrooms"))
				gcb.add(new ByNumBathrooms(Integer.parseInt((String)specMap.get("Bathrooms"))));
			
			else if(entry.getKey().equals("AllowingPets"))
				gcb.add(new ByPets(specMap.get("AllowingPets").toString()));
			
			else if(entry.getKey().equals("Amenities"))
				gcb.add(new ByAmenities(specMap.get("Amenities").toString()));
			
			else if(entry.getKey().equals("LeaseLength"))
				gcb.add(new ByLeaseLength(Integer.parseInt((String) entry.getValue())));
		}
		
		sh.searchAll(gcb);
		gcb.clear();
	}
	
	

}
