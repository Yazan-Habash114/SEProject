package product.app;

public class Home {
	// Attributes
	private String placement;
	private String material;
	private int rent;
	private int area;
	private int number_of_bedrooms;
	private int bathrooms;
	private boolean allow_pets;
	private String type;
	private String lease_length;
	private boolean air_Condition;
	private boolean balcony;
	private boolean elevator;
	private boolean fire_place;
	private boolean garage_parking;
	private boolean swimming_pool;
		
	Home(){
		// Initialize the attributes
		this.placement = null;
		this.material = null;
		this.rent = 0;
		this.area = 0;
		this.number_of_bedrooms = 0;
		this.bathrooms = 0;
		this.allow_pets = false;
		this.type = null;
		this.lease_length = null;
		this.air_Condition = false;
		this.balcony = false;
		this.elevator = false;
		this.fire_place = false;
		this.garage_parking = false;
		this.swimming_pool = false;
	}
}
