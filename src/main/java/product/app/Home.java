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

	public Home(String[] list) {

		this.type = list[0];
		this.material = list[1];
		this.placement = list[2];
		this.allowPets = list[3].equals("YES");
		this.airCondition = list[4].contains("AIRCONDITIONING");
		this.balcony = list[4].contains("BALCONY");
		this.elevator = list[4].contains("ELEVATOR");
		this.firePlace = list[4].contains("FIREPLACE");
		this.swimmingPool = list[4].contains("SWIMMINGPOOL");
		this.price = Integer.parseInt(list[5]);
		this.area = Integer.parseInt(list[6]);
		this.bedrooms = Integer.parseInt(list[7]);
		this.bathrooms = Integer.parseInt(list[8]);
		this.leaseLength = Integer.parseInt(list[9]);

	}

	@Override
	public String toString() {
		return "Home [placement=" + placement + ", material=" + material + ", price=" + price + ", area=" + area
				+ ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms + ", allow_pets=" + allowPets + ", type=" + type
				+ ", lease_length=" + leaseLength + ", air_Condition=" + airCondition + ", balcony=" + balcony
				+ ", elevator=" + elevator + ", fire_place=" + firePlace + ", garage_parking=" + garageParking
				+ ", swimming_pool=" + swimmingPool + "]";
	}
	

	public boolean hasAirCondition() {
		return airCondition;
	}

	public boolean hasBalcony() {
		return balcony;
	}

	public boolean hasElevator() {
		return elevator;
	}

	public boolean hasFirePlace() {
		return firePlace;
	}

	public boolean hasGarageParking() {
		return garageParking;
	}

	public boolean hasSwimmingPool() {
		return swimmingPool;
	}

	public String getPlacement() {
		return placement;
	}

	public String getMaterial() {
		return material;
	}

	public int getPrice() {
		return price;
	}

	public int getArea() {
		return area;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public boolean isAllowPets() {
		return allowPets;
	}

	public String getType() {
		return type;
	}
	
	public int getLeaseLength() {
		return leaseLength;
	}
  
}
