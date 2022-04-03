package cryptoTrader.gui;
public class StrategyA extends Strategy {
	
	
	public StrategyA(String brokerName) {
		requiredCoins.set(0, "BTC"); 
		requiredCoins.set(1,  "ETH");
		strategy = "Strategy-A";
		this.brokerName = brokerName;
	}
	
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
			return summary;
		} else {
			tradeSummary summary = new tradeSummary(brokerName, strategy, "null", "fail", "null", "null");
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

