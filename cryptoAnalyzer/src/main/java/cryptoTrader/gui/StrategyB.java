package cryptoTrader.gui;
public class StrategyB extends Strategy {
	
	
	public StrategyB(String brokerName) {
		strategy = "Strategy-B";
		requiredCoins.set(0,  "ETH");
		requiredCoins.set(1,  "DOGE");
		this.brokerName = brokerName;
		
	}
	
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
