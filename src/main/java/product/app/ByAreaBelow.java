package product.app;

public class ByAreaBelow implements GeneralCheckBy {
	
	private int area;
	
	public ByAreaBelow(int area) {
		this.area = area;
	}

	public int getArea() {
		return area;
	}

	public boolean isMatched(Home h) {
		return h.chkAreaBelow(getArea());
	}
	
}
