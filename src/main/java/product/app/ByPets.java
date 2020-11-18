package product.app;

public class ByPets implements GeneralCheckBy {
	
	private String allowed;
	
	public ByPets(String allowed) {
		this.allowed = allowed;
	}

	public boolean isMatched(Home h) {
		if(this.allowed.contentEquals("YES"))
			return(h.isAllowPets());
		return(true);
	}
	
	@Override
	public String toString() {
		return(" allowing pets (" + this.allowed + ")");
	}
	
}
