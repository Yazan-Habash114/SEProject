package product.app;

public class ByPriceBelow implements GeneralCheckBy {
	
	private int price;
	
	public ByPriceBelow(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}

	public boolean isMatched(Home h) {
		return h.chkPriceBelow(getPrice());
	}
	
}
