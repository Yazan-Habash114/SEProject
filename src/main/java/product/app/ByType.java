package product.app;

public class ByType implements GeneralCheckBy {
	
	private String type;

	public ByType(String type) {
		this.type = type;
	}

	public boolean isMatched(Home h) {
		return(h.getType().contentEquals(this.type));
	}
	
	@Override
	public String toString() {
		return(" match the type '" + this.type + "'");
	}
	
}
