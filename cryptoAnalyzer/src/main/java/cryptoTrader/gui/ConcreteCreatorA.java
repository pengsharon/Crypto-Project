/**
* The ConcreateCreatorA implements a class that extends from Creator 
* to create StrategyA object with the factoryMethod
*
* @author  Deanna Chen, Nicole Han, Nick Lam, Sharon Peng
* @version 1.0
* @since   2014-03-31 
*/

package cryptoTrader.gui;

/**
 * this class is used as the concrete creator in the factory method for strategy A
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class ConcreteCreatorA extends Creator {
	/**
	* creates the concrete strategies for each broker
	* 
	* @param brokerName the name of the broker
	* @return Strategy the specific strategy to create 
	*/
	
	/**
	 * this method defines the factory method for strategy A
	 * @param brokerName - name of the broker
	 * @return a object of Strategy A
	 */
	public Strategy factoryMethod(String brokerName) {
		return new StrategyA(brokerName);
	}

}
