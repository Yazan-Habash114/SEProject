package product.app;

public class ByPriceBelow implements GeneralCheckBy {
	
	private int price;
	
	public ByPriceBelow(int price) {
		this.price = price;
	}

	public boolean isMatched(Home h) {
		return(h.getPrice() < this.price);
	}
	
}
