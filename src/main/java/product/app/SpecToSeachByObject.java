package product.app;

import java.util.ArrayList;
import java.util.Map;

public class SpecToSeachByObject {
	private ArrayList <GeneralCheckBy> gcb; 
	SearchHomes sh = SearchHomes.singletonSearchHomes();
	
	// Constructor
	public SpecToSeachByObject() {
		gcb = new ArrayList<GeneralCheckBy>();
	}
	public void convertToObject(Map<String, Object> specMap) {
		if(specMap.get("placement")!=null)
			gcb.add(new ByPlacement(specMap.get("placement").toString()));
		
		else if(specMap.get("type")!=null)
			gcb.add(new ByType(specMap.get("type").toString()));
		
		else if(specMap.get("material")!=null)
			gcb.add(new ByMaterial(specMap.get("material").toString()));
		
		else if(specMap.get("pricebelow")!=null)
			gcb.add(new ByPriceBelow(Integer.parseInt((String)specMap.get("pricebelow"))));
		
		else if(specMap.get("pricebetween")!=null) { 
			Integer[] tmp = (Integer[])(specMap.get("pricebetween"));
			gcb.add(new ByPriceBetween(tmp[0].intValue(),tmp[1].intValue()));
		}
		
		else if(specMap.get("areabelow")!=null)
			gcb.add(new ByAreaBelow(Integer.parseInt((String)specMap.get("areabelow"))));
		
		else if(specMap.get("areabetween")!=null) { 
			Integer[] tmp = (Integer[])(specMap.get("areabetween"));
			gcb.add(new ByAreaBetween(tmp[0].intValue(),tmp[1].intValue()));
		}
		
		else if(specMap.get("bedrooms")!=null)
			gcb.add(new ByNumBedrooms(Integer.parseInt((String)specMap.get("bedrooms"))));
		
		else if(specMap.get("bathrooms")!=null)
			gcb.add(new ByNumBathrooms(Integer.parseInt((String)specMap.get("bathrooms"))));
		
		else if(specMap.get("allowingPets")!=null)
			gcb.add(new ByPets(specMap.get("allowingPets").toString()));
		
		else if(specMap.get("leaseLength")!=null)
			gcb.add(new ByLeaseLength(Integer.parseInt((String)specMap.get("leaseLength"))));
			
		else if(specMap.get("amenities")!=null)
			gcb.add(new ByAmenities(specMap.get("amenities").toString()));
			
		sh.SearchAll(gcb);
		gcb.clear();
	}
	
	

}
