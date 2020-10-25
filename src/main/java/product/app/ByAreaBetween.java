package product.app;

public class ByAreaBetween implements GeneralCheckBy {
	
	private int low;
	private int high;
	
	public ByAreaBetween(int low, int high) {
		this.low = low;
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public int getHigh() {
		return high;
	}

	public boolean isMatched(Home h) {
		return h.chkAreaInRange(getLow(), getHigh());
	}
	
}
