package product.app;

public class ByAreaBelow implements GeneralCheckBy {
	
	private int area;
	
	public ByAreaBelow(int area) {
		this.area = area;
	}

	public boolean isMatched(Home h) {
		return (h.getArea() < this.area);
	}
	
}
