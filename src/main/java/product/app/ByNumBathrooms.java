package product.app;

public class ByNumBathrooms implements GeneralCheckBy {

	private int num;

	public ByNumBathrooms(int num) {
		this.num = num;
	}

	public boolean isMatched(Home h) {
		return (h.getBathrooms() == num);
	}
	
	@Override
	public String toString() {
		return(" number of bathrooms = " + this.num);
	}

}
