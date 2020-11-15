package product.app;

public class ByAmenities implements GeneralCheckBy {

	private String amenities;

	public ByAmenities(String amenities) {
		this.amenities = amenities;
	}

	public boolean isMatched(Home h) {
		return !( amenities.contains("SWIMMINGPOOL") && !h.hasSwimmingPool()
				|| amenities.contains("AIRCONDITIONING") && !h.hasAirCondition()
				|| amenities.contains("BALCONY") && !h.hasBalcony() 
				|| amenities.contains("ELEVATOR") && !h.hasElevator()
				|| amenities.contains("FIREPLACE") && !h.hasFirePlace()
				|| amenities.contains("GARAGEPARKING") && !h.hasGarageParking()
				);
	}
	
	@Override
	public String toString() {
		return("have amenites '" + this.amenities + "'");
	}

}