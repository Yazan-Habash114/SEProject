package product.app;

public class ByMaterial {
	
	private String material;
	
	public ByMaterial(String material) {
		this.material = material;
	}
	
	public String getMaterial() {
		return this.material;
	}

	public boolean isMatched(Home h) {
		return h.chkMaterial(getMaterial());
	}

}
