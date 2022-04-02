package cryptoTrader.gui;
import java.util.ArrayList;
public class StrategyD extends Strategy{
	private String strategy = "Strategy-D";
	private boolean valid;
	private ArrayList<String> requiredCoins = new ArrayList<String>() {
		{
			add("DOGE");
			add("TRX");
		}
	};
	
	public StrategyD(String[] givenCoins, String brokerName, boolean valid) {
		super(givenCoins, brokerName);
		this.valid = valid;
		
		// TODO Auto-generated constructor stub	
	}
	
	private tradeSummary performStrategyD(double dogePrice, double trxPrice) {
		String coin;
		String action;
		int quantity;
		double price;
		if(dogePrice > trxPrice) {
			coin = "DOGE";
			price = dogePrice;
		}
		else {
			coin = "TRX";
			price = trxPrice;
		}
		action = "Sell";
		quantity = 200;
		tradeSummary summary = new tradeSummary(brokerName, strategy, coin, action, quantity, price);
		return summary;
	}
}
