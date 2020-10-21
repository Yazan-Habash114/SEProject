package product.app;

public class Home {
	// Attributes
	private String placement;
	private String material;
	private int price;
	private int area;
	private int bedrooms;
	private int bathrooms;
	private boolean allowPets;
	private String type;
	private int leaseLength;
	private boolean airCondition;
	private boolean balcony;
	private boolean elevator;
	private boolean firePlace;
	private boolean garageParking;
	private boolean swimmingPool;
	
		
	public Home(String type, String material, String placement, String pets, String amenities, 
			int price, int area, int bedrooms, int bathrooms, int leaseLength){
		// Initialize the attributes
		this.placement = placement;
		this.material = material;
		this.price = price;
		this.area = area;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.allowPets = pets.equals("YES");
		this.type = type;
		this.leaseLength = leaseLength;
		this.airCondition = amenities.contains("AIRCONDITIONING");
		this.balcony = amenities.contains("BALCONY");
		this.elevator = amenities.contains("ELEVATOR");
		this.firePlace = amenities.contains("FIREPLACE");
		this.garageParking = amenities.contains("GARAGEPARKING");
		this.swimmingPool = amenities.contains("SWIMMINGPOOL");
	}


	@Override
	public String toString() {
		return "Home [placement=" + placement + ", material=" + material + ", price=" + price + ", area=" + area
				+ ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", allow_pets=" + allowPets + ", type="
				+ type + ", lease_length=" + leaseLength + ", air_Condition=" + airCondition + ", balcony=" + balcony
				+ ", elevator=" + elevator + ", fire_place=" + firePlace + ", garage_parking=" + garageParking
				+ ", swimming_pool=" + swimmingPool + "]";
	}


	public boolean chkPlacement(String value) {
		return(this.placement.equals(value));
	}


	public boolean chkMaterial(String value) {
		return (this.material.contentEquals(value));
	}


	public boolean chkPriceBelow(int parseInt) {
		return(this.price < parseInt);
	}


	public boolean chkPriceInRange(int low, int high) {
		return((low < this.price) && (this.price < high));
	}


	public boolean chkAreaBelow(int area2) {
		return(this.area < area2);
	}


	public boolean chkAreaInRange(int low, int high) {
		return((low < this.area) && (this.area < high));
	}


	public boolean chkNumberOfBedrooms(int num) {
		return(this.bedrooms == num);
	}


	public boolean chkNumberOfBathrooms(int num) {
		return(this.bathrooms == num);
	}

	
	public boolean chkAllowingPets(String value) {
		return(value.equals("YES") ? (this.allowPets) : (!this.allowPets));
	}

	
	public boolean chkType(String value) {
		return(value.equals(this.type));
	}


	public boolean chkLeaseLength(int value) {
		return(this.leaseLength == value);
	}

	
	public boolean chkAmenities(String[] amenities) {
		for (String amenity : amenities)
			if (amenity.equals("AIRCONDITIONING") && !this.airCondition)
				return false;
			else if (amenity.equals("BALCONY") && !this.balcony)
		    	return false;
			else if (amenity.equals("ELEVATOR") && !this.elevator)
		    	return false;
			else if (amenity.equals("FIREPLACE") && !this.firePlace)
		    	return false;
			else if (amenity.equals("GARAGEPARKING") && !this.garageParking)
		    	return false;
			else if (amenity.equals("SWIMMINGPOOL") && !this.swimmingPool)
		    	return false;
		return true;
	}

}
