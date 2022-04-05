package cryptoTrader.gui;

/**
 * this class defines the Strategy factory method 
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public abstract class Creator {
	
	/**
	 * defines the strategy factory method
	 * @param brokerName - name of the broker
	 */
	public abstract Strategy factoryMethod(String brokerName);

}
