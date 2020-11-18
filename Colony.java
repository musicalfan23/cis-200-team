public class Colony {
	private String[] supplies;
	private boolean isFriendly;
	
	public Colony() {
		supplies = null;
		isFriendly = true;
	}
	
	public Colony(String[] s, boolean iF) {
		supplies = s;
		isFriendly = iF;
	}
	
	public void setSupplies(String[] s) {
		supplies = s;
	}
	
	public String[] getSupplies() {
		return supplies;
	}
} // end Colony