package product.app;

public class ByPlacement implements GeneralCheckBy {
	
	private String placement;

	public ByPlacement(String placement) {
		this.placement = placement;
	}

	public String getPlacement() {
		return this.placement;
	}

	public boolean isMatched(Home h) {
		return h.chkPlacement(getPlacement());
	}
	
}
