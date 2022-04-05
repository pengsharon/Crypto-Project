/**
* The brokerInfo program implements a class that sets and returns deatils about each broker
*
* @author  Deanna Chen, Nicole Han, Nick Lam, Sharon Peng
* @version 1.0
* @since   2014-03-31 
*/

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
	* The constructor of the class brokerInfo
	*
	* @param brokerName the string to set as the brokerName
	* @param coinList a String array that stores the coins associated with the broker
	* @param stratName the name of the strategy
	*/
	public brokerInfo(String brokerName, String[] coinList, String stratName) {
		this.brokerName = brokerName;
		this.coinList = coinList;
		this.stratName = stratName;
	}
	
	/**
	* @return brokerName the name of the broker
	*/
	public String getBName() {
		return brokerName;
	}
	
	/**
	* @return coinList String array that stores the list of coins associated with the broker
	*/
	public String[] getCoinList() {
		return coinList;
	}
	
	/**
	* @return stratName strategy name
	*/
	public String getStratName() {
		return stratName;
	}
	
	// setters not necessary

}
