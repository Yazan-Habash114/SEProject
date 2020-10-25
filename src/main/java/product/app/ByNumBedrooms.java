package product.app;

public class ByNumBedrooms implements GeneralCheckBy {
	
	private int num;
	
	public ByNumBedrooms(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public boolean isMatched(Home h) {
		return h.chkNumberOfBedrooms(getNum());
	}
	
}
