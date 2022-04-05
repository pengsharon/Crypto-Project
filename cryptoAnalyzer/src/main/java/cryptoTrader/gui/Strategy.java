package cryptoTrader.gui;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * This class is mainly used to validate the strategies that are executed by the program which the user chooses
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public abstract class Strategy {
	
	protected String[] givenCoins;
	protected ArrayList<String> requiredCoins = new ArrayList<String>();
	protected String brokerName;
	protected String strategy;
	protected boolean isValid;
	
	/**
	 * abstract method for the trade summary 
	 * @param priceOne - input first price
	 * @param priceTwo - input second price
	 * @param isValid - input validity
	 */
	public abstract tradeSummary performStrategy(double priceOne, double priceTwo, boolean isValid);
	
	/**
	 * This method validates whether the strategy can be executed or not regarding if they have the valid coin information
	 * @param givenCoins - coins relevant to each strategy
	 * @param requiredCoins - coins unique to each strategy
	 * @return if the strategies are valid or not 
	 */
	// universal methods
	public boolean validate(String[] givenCoins, ArrayList<String> requiredCoins) {
		// System.out.println(givenCoins[0] + "     " + givenCoins[1]);
		isValid = true; 
		for(String i : requiredCoins) {
			for (int j = 0; j < givenCoins.length; j++) {
				if (i.equals(givenCoins[j])) {
					break;
				}
				if (j == givenCoins.length - 1) {
					
					isValid = false;
					JOptionPane.showMessageDialog(null, "Could not perform trade for broker: " + brokerName);
					return isValid;
				}
			}
		}
		return isValid;
	}
	
	/**
	 * gets the required coins for strategy
	 * @return requiredCoins which is the list of required coins
	 */
	public ArrayList<String> getReqCoins() {
		return requiredCoins;
	}
	
	/**
	 * gets the name of the broker
	 * @return brokerName the broker name
	 */
	public String getBrokerName() {
		return brokerName;
	}
}

//package cryptoTrader.gui;
//import java.util.ArrayList;
//public class Strategy {
//	private boolean valid;
//	protected String[] givenCoins;
//	protected ArrayList<String> requiredCoins;
//	protected String brokerName;
//	
//	public Strategy(String[] givenCoins, String brokerName) {
//		this.givenCoins = givenCoins;
//		this.brokerName = brokerName;
//	}
//	
//	public boolean validate(String[] givenCoins, ArrayList<String> requiredCoins) {
//		boolean isValid = true; //Strategy-A, Strategy-B check
//		for(String i : requiredCoins) {
//			for (int j = 0; j < givenCoins.length; j++) {
//				if (i.equals(givenCoins[j])) {
//					break;
//				}
//				if (j == givenCoins.length - 1) {
//					isValid = false;
//					return isValid;
//				}
//			}
//		}
//		return isValid;
//	}
//	
//	public ArrayList<String> getReqCoins() {
//		return requiredCoins;
//	}
//}
//
