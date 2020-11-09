package product.app;

public class ByNumBedrooms implements GeneralCheckBy {

	private int num;

	public ByNumBedrooms(int num) {
		this.num = num;
	}

	public boolean isMatched(Home h) {
		return (h.getBedrooms() == this.num);
	}
	
	@Override
	public String toString() {
		return("\nList of homes that match the Number of bedrooms = " + this.num + " :");
	}

}
