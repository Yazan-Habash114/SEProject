package product.app;

public class ByType implements GeneralCheckBy {
	
	private String type;

	public ByType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

	public boolean isMatched(Home h) {
		return h.chkType(getType());
	}
	
}
