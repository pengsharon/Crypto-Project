package cryptoTrader.gui;
public class StrategyC extends Strategy {

	
	public StrategyC(String brokerName) {
		strategy = "Strategy-C";
		requiredCoins.add("ADA");
		requiredCoins.add("XRP");
		this.brokerName = brokerName;
	}
	
	public tradeSummary performStrategy(double adaPrice, double xrpPrice, boolean isValid) {
		
		String coin;
		String action;
		String quantity;
		String price;

		if (isValid) {
			
			if(adaPrice < xrpPrice) {
				coin = "ADA";
				action = "Buy";
				quantity = "50";
				price = String.format("%.2f", adaPrice);
			}
			else {
				coin = "XRP";
				action = "Buy";
				quantity = "50";
				price = String.format("%.2f", xrpPrice);
			}
			tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
			return summary;
		} else {
			tradeSummary summary = new tradeSummary(brokerName, strategy, "null", "fail", "null", "null");
			return summary;
		}
	}
}
