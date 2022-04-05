package cryptoTrader.gui;

/**
 * This class contains the info for the broker that the user inputs
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class brokerInfo {
	
	private String brokerName;
	private String stratName;
	private String[] coinList;
	
	/**
	 * Constructor defining the data with with the associated brokerName (row)
	 * @param brokerName - name of the broker
	 * @param coinList - list of the coins inputted
	 * @param stratName - strategy chosen
	 */
	public brokerInfo(String brokerName, String[] coinList, String stratName) {
		this.brokerName = brokerName;
		this.coinList = coinList;
		this.stratName = stratName;
	}
	
	/**
	 * gets the broker name
	 * @return broker name
	 */
	public String getBName() {
		return brokerName;
	}
	
	/**
	 * gets the list of coins
	 * @return the coin list
	 */
	public String[] getCoinList() {
		return coinList;
	}
	
	/**
	 * gets the strategy chosen
	 * @return strategy (A - D)
	 */
	public String getStratName() {
		return stratName;
	}
	
	// setters not necessary

}
