package product.app;

public class ByPriceBetween implements GeneralCheckBy {
	
	private int low;
	private int high;
	
	public ByPriceBetween(int low, int high) {
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
		return h.chkPriceInRange(getLow(), getHigh());
	}
	
}
