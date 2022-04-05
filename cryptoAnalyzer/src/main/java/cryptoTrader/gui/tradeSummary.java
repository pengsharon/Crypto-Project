package cryptoTrader.gui;
import java.time.LocalDate;

/**
 * This class is used for the trade strategy containing the data for execution and display purposes
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class tradeSummary {
	private String traderName;
	private String strategy;
	private String coin;
	private String action;
	private String quantity;
	private String price;
	private LocalDate date = LocalDate.now();
	
	/**
	 * 
	 * @param traderName - broker name column 1 
	 * @param strategy - from A to D
	 * @param coin - coins for strategy computation
	 * @param action - buy or sell
	 * @param quantity - amount bought or sold
	 * @param price - price at which bought or sold
	 */
	public tradeSummary (String traderName, String strategy, String coin, String action, String quantity, String price) {
		this.traderName = traderName;
		this.strategy = strategy;
		this.coin = coin;
		this.action = action;
		this.quantity = quantity;
		this.price = price;
	}
	
	/**
	 * gets the broker/trader name
	 * @return name of trader
	 */
	public String getTraderName() {
		return traderName;
	}
	
	/**
	 * gets the strategy chosen
	 * @return strategy 
	 */
	public String getStrategy() {
		return strategy;
	}
	
	/**
	 * gets the coin bought or sold
	 * @return coing bought or sold
	 */
	public String getCoin() {
		return coin;
	}
	
	/**
	 * gets the action 
	 * @return buy or sell
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * gets the quantity of coin bought or sold
	 * @return quantity 
	 */
	public String getQuantity() {
		return quantity;
	}
	
	/**
	 * gets the price of the coin
	 * @return price of coin
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * gets the current date
	 * @return gets data at which exercised
	 */
	public String getDate() {
		return date.toString();
	}
}
