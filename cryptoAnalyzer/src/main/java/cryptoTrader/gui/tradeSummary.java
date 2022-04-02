package cryptoTrader.gui;
import java.time.LocalDate;

public class tradeSummary {
	private String traderName;
	private String strategy;
	private String coin;
	private String action;
	private String quantity;
	private String price;
	private LocalDate date = LocalDate.now();
	
	public tradeSummary (String traderName, String strategy, String coin, String action, String quantity, String price) {
		this.traderName = traderName;
		this.strategy = strategy;
		this.coin = coin;
		this.action = action;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getTraderName() {
		return traderName;
	}
	
	public String getStrategy() {
		return strategy;
	}
	
	public String getCoin() {
		return coin;
	}
	
	public String getAction() {
		return action;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public String getPrice() {
		return price;
	}
	
	public LocalDate date() {
		return date;
	}
}
