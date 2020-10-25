package product.app;

public class ByNumBathrooms implements GeneralCheckBy {
	
	private int num;
	
	public ByNumBathrooms(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public boolean isMatched(Home h) {
		return h.chkNumberOfBathrooms(getNum());
	}
	
}
