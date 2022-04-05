/**
* The Creator an abstract class that has the abstract factoryMethod 
*
* @author  Deanna Chen, Nicole Han, Nick Lam, Sharon Peng
* @version 1.0
* @since   2014-03-31 
*/

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
