package product.app;

public class ByMaterial implements GeneralCheckBy {
	
	private String material;
	
	public ByMaterial(String material) {
		this.material = material;
	}

	public boolean isMatched(Home h) {
		return (h.getMaterial().contentEquals(this.material));
	}
	
	@Override
	public String toString() {
		return("\nList of homes that match the Material specification '" + this.material + "' :");
	}

}
