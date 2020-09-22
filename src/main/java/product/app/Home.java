package product.app;

public class Home {
	// Attributes
	private String placement;
	private String material;
	private int price;
	private int area;
	private int bedrooms;
	private int bathrooms;
	private boolean allow_pets;
	private String type;
	private int lease_length;
	private boolean air_Condition;
	private boolean balcony;
	private boolean elevator;
	private boolean fire_place;
	private boolean garage_parking;
	private boolean swimming_pool;
	
		
	Home(String type, String material, String placement, String pets, String amenities, 
			int price, int area, int bedrooms, int bathrooms, int lease_length){
		// Initialize the attributes
		this.placement = placement;
		this.material = material;
		this.price = price;
		this.area = area;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.allow_pets = pets.equals("YES") ? true: false;
		this.type = type;
		this.lease_length = lease_length;
		this.air_Condition = amenities.contains("AIRCONDITIONING") ? true: false;
		this.balcony = amenities.contains("BALACONY") ? true: false;
		this.elevator = amenities.contains("ELEVATOR") ? true: false;
		this.fire_place = amenities.contains("FIREPLACE") ? true: false;
		this.garage_parking = amenities.contains("GARAGEPARKING") ? true: false;
		this.swimming_pool = amenities.contains("SWIMMINGPOOL") ? true: false;
	}


	@Override
	public String toString() {
		return "Home [placement=" + placement + ", material=" + material + ", price=" + price + ", area=" + area
				+ ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", allow_pets=" + allow_pets + ", type="
				+ type + ", lease_length=" + lease_length + ", air_Condition=" + air_Condition + ", balcony=" + balcony
				+ ", elevator=" + elevator + ", fire_place=" + fire_place + ", garage_parking=" + garage_parking
				+ ", swimming_pool=" + swimming_pool + "]";
	}


	public boolean chkPlacement(String value) {
		return(this.placement.equals(value));
	}


	public boolean chkMaterial(String value) {
		return (this.material.contentEquals(value));
	}


	public boolean chkPriceBelow(int parseInt) {
		return(this.price == parseInt);
	}

}
