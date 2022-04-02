package cryptoTrader.gui;
import java.util.ArrayList;
public class StrategyC extends Strategy {
	private String strategy = "Strategy-C";
	private boolean valid;
	private ArrayList<String> requiredCoins = new ArrayList<String>() {
		{
			add("ADA");
			add("XRP");
		}
	};
	
	public StrategyC(String[] givenCoins, String brokerName) {
		super(givenCoins, brokerName);
		this.valid = valid;
		
		// TODO Auto-generated constructor stub	
	}
	
	private tradeSummary performStrategyC(double adaPrice, double xrpPrice, boolean isValid) {
		
		String coin;
		String action;
		String quantity;
		String price;

		if (isValid) {
			
			if(adaPrice < xrpPrice) {
				coin = "ADA";
				action = "Buy";
				quantity = "50";
				price = String.valueOf(adaPrice);
			}
			else {
				coin = "XRP";
				action = "Buy";
				quantity = "50";
				price = String.valueOf(xrpPrice);
			}
			tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
			return summary;
		} else {
			tradeSummary summary = new tradeSummary(brokerName, strategy, "null", "fail", "null", "null");
			return summary;
		}
	}
}
