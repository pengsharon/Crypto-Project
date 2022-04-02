package cryptoTrader.gui;
import java.util.ArrayList;
public class Strategy {
	private boolean valid;
	protected String[] givenCoins;
	protected ArrayList<String> requiredCoins;
	protected String brokerName;
	
	public Strategy(String[] givenCoins, String brokerName) {
		this.givenCoins = givenCoins;
		this.brokerName = brokerName;
	}
	
	public boolean validate(String[] givenCoins, ArrayList<String> requiredCoins) {
		boolean isValid = true; //Strategy-A, Strategy-B check
		for(String i : requiredCoins) {
			for (int j = 0; j < givenCoins.length; j++) {
				if (i.equals(givenCoins[j])) {
					break;
				}
				if (j == givenCoins.length - 1) {
					isValid = false;
					return isValid;
				}
			}
		}
		return isValid;
	}
	
	public ArrayList<String> getReqCoins() {
		return requiredCoins;
	}
}
