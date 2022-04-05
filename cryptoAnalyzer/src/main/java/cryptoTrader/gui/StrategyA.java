package cryptoTrader.gui;

/**
 * This class is the Strategy A class that can be chosen by the user to perform after inputting the necessary coins
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class StrategyA extends Strategy {
	
	/**
	 * constructor 
	 * @param brokerName - name of the broker
	 */
	public StrategyA(String brokerName) {
		requiredCoins.add("BTC");
		requiredCoins.add("ETH");
		strategy = "Strategy-A";
		this.brokerName = brokerName;
	}
	
	/**
	 * trade summary that gets input as the necessary coin prices to compute the trading strategy and also if the coins are valid
	 * @param btcPrice - price of bitcoin for the day
	 * @param ethPrice - price of ethereum for the day
	 * @param isValid - if the coins are valid for the strategy
	 */
	public tradeSummary performStrategy(double btcPrice, double ethPrice, boolean isValid) {
		String coin;
		String action;
		String quantity;
		String price;

		if (isValid) {
			
			if(btcPrice > 14*ethPrice) {
				coin = "ETH";
				action = "Buy";
				quantity = "500";
				price = String.valueOf(ethPrice);
			}
			else {
				coin = "BTC";
				action = "Sell";
				quantity = "1";
				price = String.valueOf(btcPrice);
			}
			tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
			System.out.println("\nTesting: " + brokerName + ", " + strategy + ", " + coin + ", " + action + ", " + price + "\n\n");
			
			// return the summary
			return summary;
		} else {
			tradeSummary summary = new tradeSummary(brokerName, strategy, "null", "fail", "null", "null");
			// was not a valid execution
			return summary;
		}		
		
	}
}

//package cryptoTrader.gui;
//import java.util.ArrayList;
//public class StrategyA extends Strategy {
//	private String strategy = "Strategy-A";
//	private boolean valid;
//	private ArrayList<String> requiredCoins = new ArrayList<String>() {
//		{
//			add("BTC");
//			add("ETH");
//		}
//	};
//	
//	public StrategyA(String[] givenCoins, String brokerName) {
//		
//		this.givenCoins = givenCoins;
//		this.brokerName = brokerName;
//
//	}
//	
//	private tradeSummary performStrategyA(double btcPrice, double ethPrice, boolean isValid) {
//		String coin;
//		String action;
//		String quantity;
//		String price;
//
//		if (isValid) {
//			
//			if(btcPrice > 14*ethPrice) {
//				coin = "ETH";
//				action = "Buy";
//				quantity = "500";
//				price = String.valueOf(ethPrice);
//			}
//			else {
//				coin = "BTC";
//				action = "Sell";
//				quantity = "1";
//				price = String.valueOf(btcPrice);
//			}
//			tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
//			return summary;
//		} else {
//			tradeSummary summary = new tradeSummary(brokerName, strategy, "null", "fail", "null", "null");
//			return summary;
//		}		
//	}
//}

