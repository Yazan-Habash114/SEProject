package product.app;

public class ByPets implements GeneralCheckBy {
	
	private String allowed;
	
	public ByPets(String allowed) {
		this.allowed = allowed;
	}

	public String getAllowed() {
		return allowed;
	}

	public boolean isMatched(Home h) {
		return h.chkAllowingPets(getAllowed());
	}
	
}
