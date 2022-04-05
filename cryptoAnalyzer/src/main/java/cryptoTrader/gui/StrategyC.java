package cryptoTrader.gui;

/**
 * This class is the Strategy A class that can be chosen by the user to perform after inputting the necessary coins
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class StrategyC extends Strategy {

	/**
	 * constructor 
	 * @param brokerName - name of the broker
	 */
	public StrategyC(String brokerName) {
		strategy = "Strategy-C";
		requiredCoins.add("ADA");
		requiredCoins.add("XRP");
		this.brokerName = brokerName;
	}
	
	/**
	 * trade summary that gets input as the necessary coin prices to compute the trading strategy and also if the coins are valid
	 * @param adaPrice - price of cardano for the day
	 * @param xrp - price of ripple for the day
	 * @param isValid - if the coins are valid for the strategy
	 */
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
