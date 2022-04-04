package cryptoTrader.gui;
public class StrategyD extends Strategy{

	public StrategyD(String brokerName) {
		strategy = "Strategy-D";
		requiredCoins.add("DOGE");
		requiredCoins.add("TRX");
		this.brokerName = brokerName;
	}
	
	@Override
	public tradeSummary performStrategy(double dogePrice, double trxPrice, boolean isValid) {
		
		String coin;
		String action;
		String quantity;
		String price;

		if (isValid) {
			
			if(dogePrice > trxPrice) {
				coin = "DOGE";
				action = "Sell";
				quantity = "200";
				price = String.format("%.2f", dogePrice);
			}
			else {
				coin = "TRX";
				action = "Sell";
				quantity = "200";
				price = String.format("%.2f", trxPrice);
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
//public class StrategyD extends Strategy{
//	private String strategy = "Strategy-D";
//	private boolean valid;
//	private ArrayList<String> requiredCoins = new ArrayList<String>() {
//		{
//			add("DOGE");
//			add("TRX");
//		}
//	};
//	
//	public StrategyD(String[] givenCoins, String brokerName) {
//		super(givenCoins, brokerName);
//		this.valid = valid;
//		
//		// TODO Auto-generated constructor stub	
//	}
//	
//	private tradeSummary performStrategyD(double dogePrice, double trxPrice, boolean isValid) {
//		
//		String coin;
//		String action;
//		String quantity;
//		String price;
//
//		if (isValid) {
//			
//			if(dogePrice > trxPrice) {
//				coin = "DOGE";
//				action = "Sell";
//				quantity = "200";
//				price = String.valueOf(dogePrice);
//			}
//			else {
//				coin = "TRX";
//				action = "Sell";
//				quantity = "200";
//				price = String.valueOf(trxPrice);
//			}
//			tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
//			return summary;
//		} else {
//			tradeSummary summary = new tradeSummary(brokerName, strategy, "null", "fail", "null", "null");
//			return summary;
//		}
//	}
//}
