package product.app;

public class ByNumBedrooms implements GeneralCheckBy {
	
	private int num;
	
	public ByNumBedrooms(int num) {
		this.num = num;
	}

	public boolean isMatched(Home h) {
		return (h.getBedrooms() == this.num);
	}
	
}
