package product.app;

public class ByPlacement implements GeneralCheckBy {
	
	private String placement;

	public ByPlacement(String placement) {
		this.placement = placement;
	}

	public boolean isMatched(Home h) {
		return (h.getPlacement().contentEquals(this.placement));
	}
	
}
