package cryptoTrader.gui;
import java.util.ArrayList;
public class Strategy {
	private boolean valid;
	private String[] givenCoins;
	private String[] requiredCoins;
	protected String brokerName;
	
	public Strategy(String[] givenCoins, String brokerName) {
		this.givenCoins = givenCoins;
		this.brokerName = brokerName;
	}
	
	private boolean validate(String[] givenCoins, ArrayList<String> requiredCoins) {
		boolean isValid = true; //Strategy-A, Strategy-B check
		if(requiredCoins.get(0) != null) {
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
		else {
			if(givenCoins.length != 3) {
				isValid = false;
			}
		}
		return isValid;
	}
}
