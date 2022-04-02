package cryptoTrader.gui;
import java.time.LocalDate;

public class tradeSummary {
	private String traderName;
	private String strategy;
	private String coin;
	private String action;
	private int quantity;
	private double price;
	private LocalDate date = LocalDate.now();
	
	public tradeSummary (String traderName, String strategy, String coin, String action, int quantity, double price) {
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
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public LocalDate date() {
		return date;
	}
}
