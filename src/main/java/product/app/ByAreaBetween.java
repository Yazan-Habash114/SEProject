package product.app;

public class ByAreaBetween implements GeneralCheckBy {
	
	private int low;
	private int high;
	
	public ByAreaBetween(int low, int high) {
		this.low = low;
		this.high = high;
	}

	public boolean isMatched(Home h) {
		return (this.low > h.getArea() && h.getArea() < this.high);
	}
	
	@Override
	public String toString() {
		return("in area range (" + this.low + ", " + this.high + ")");
	}
}
