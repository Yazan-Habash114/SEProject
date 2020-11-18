package product.app;

public class ByPriceBetween implements GeneralCheckBy {
	
	private int low;
	private int high;
	
	public ByPriceBetween(int low, int high) {
		this.low = low;
		this.high = high;
	}

	public boolean isMatched(Home h) {
		return(this.low < h.getPrice() && this.high > h.getPrice());
	}
	
	@Override
	public String toString() {
		return(" in the price range (" + this.low + ", " + this.high + ")");
	}
}
