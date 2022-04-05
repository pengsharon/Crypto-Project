package cryptoTrader.gui;

/**
 * This class is the Strategy B class that can be chosen by the user to perform after inputting the necessary coins
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class StrategyB extends Strategy {
	
	/**
	 * constructor 
	 * @param brokerName - name of the broker
	 */
	public StrategyB(String brokerName) {
		strategy = "Strategy-B";
		requiredCoins.add("ETH");
		requiredCoins.add("DOGE");
		this.brokerName = brokerName;
		
	}
	
	/**
	 * trade summary that gets input as the necessary coin prices to compute the trading strategy and also if the coins are valid
	 * @param ethPrice - price of ethereum for the day
	 * @param dogePrice - price of dogecoin for the day
	 * @param isValid - if the coins are valid for the strategy
	 */
	public tradeSummary performStrategy(double ethPrice, double dogePrice, boolean isValid) {
		
		String coin;
		String action;
		String quantity;
		String price;

		if (isValid) {
			
			if(ethPrice > 1000*dogePrice) {
				coin = "DOGE";
				action = "Buy";
				quantity = "100";
				price = String.valueOf(dogePrice);
			}
			else {
				coin = "DOGE";
				action = "Sell";
				quantity = "200";
				price = String.valueOf(dogePrice);
			}
			tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
			return summary;
		} else {
			tradeSummary summary = new tradeSummary(brokerName, strategy, "null", "fail", "null", "null");
			return summary;
		}
	}

}


//package cryptoTrader.gui;
//import java.util.ArrayList;
//public class StrategyB extends Strategy {
//	private String strategy = "Strategy-B";
//	private boolean valid;
//	private ArrayList<String> requiredCoins = new ArrayList<String>() {
//		{
//			add("DOGE");
//			add("ETH");
//		}
//	};
//	
//	public StrategyB(String[] givenCoins, String brokerName) {
//		super(givenCoins, brokerName);
//		this.valid = valid;
//		
//		// TODO Auto-generated constructor stub	
//	}
//	
//	private tradeSummary performStrategyB(double ethPrice, double dogePrice, boolean isValid) {
//		
//		String coin;
//		String action;
//		String quantity;
//		String price;
//
//		if (isValid) {
//			
//			if(ethPrice > 1000*dogePrice) {
//				coin = "DOGE";
//				action = "Buy";
//				quantity = "100";
//				price = String.valueOf(dogePrice);
//			}
//			else {
//				coin = "DOGE";
//				action = "Sell";
//				quantity = "200";
//				price = String.valueOf(dogePrice);
//			}
//			tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
//			return summary;
//		} else {
//			tradeSummary summary = new tradeSummary(brokerName, strategy, "null", "fail", "null", "null");
//			return summary;
//		}
//	}
//
//}
