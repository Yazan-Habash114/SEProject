package product.app;

public class ByLeaseLength implements GeneralCheckBy {
	
	private final int leaseLength;
	
	public ByLeaseLength(int leaseLength) {
		this.leaseLength = leaseLength;
	}

	public boolean isMatched(Home h) {
		return(h.getLeaseLength() == this.leaseLength);
	}
	
	@Override
	public String toString() {
		return(" lease length of '" + this.leaseLength + "'");
	}

}
