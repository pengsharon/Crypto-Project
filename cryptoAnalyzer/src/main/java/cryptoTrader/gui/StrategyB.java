package cryptoTrader.gui;
import java.util.ArrayList;
public class StrategyB extends Strategy {
	private String strategy = "Strategy-B";
	private boolean valid;
	private ArrayList<String> requiredCoins = new ArrayList<String>() {
		{
			add("DOGE");
			add("ETH");
		}
	};
	
	public StrategyB(String[] givenCoins, String brokerName, boolean valid) {
		super(givenCoins, brokerName);
		this.valid = valid;
		
		// TODO Auto-generated constructor stub	
	}
	
	private tradeSummary performStrategyB(double ethPrice, double dogePrice) {
		String coin;
		String action;
		int quantity;
		double price;
		if(ethPrice > 1000*dogePrice) {
			coin = "DOGE";
			action = "Buy";
			quantity = 100;
			price = dogePrice;
		}
		else {
			coin = "DOGE";
			action = "Sell";
			quantity = 200;
			price = dogePrice;
		}
		tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
		return summary;
	}
}
