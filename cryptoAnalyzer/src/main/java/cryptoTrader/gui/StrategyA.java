package cryptoTrader.gui;
import java.util.ArrayList;
public class StrategyA extends Strategy {
	private String strategy = "Strategy-A";
	private boolean valid;
	private ArrayList<String> requiredCoins = new ArrayList<String>() {
		{
			add("BTC");
			add("ETH");
		}
	};
	
	public StrategyA(String[] givenCoins, String brokerName, boolean valid) {
		super(givenCoins, brokerName);
		this.valid = valid;
		
		// TODO Auto-generated constructor stub	
	}
	
	private tradeSummary performStrategyA(double btcPrice, double ethPrice) {
		String coin;
		String action;
		int quantity;
		double price;
		if(btcPrice > 14*ethPrice) {
			coin = "ETH";
			action = "Buy";
			quantity = 500;
			price = ethPrice;
		}
		else {
			coin = "BTC";
			action = "Sell";
			quantity = 1;
			price = btcPrice;
		}
		tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
		return summary;
	}
}
