/**
* The ConcreateCreatorB implements a class that extends from Creator 
* to create StrategyB object with the factoryMethod
*
* @author  Deanna Chen, Nicole Han, Nick Lam, Sharon Peng
* @version 1.0
* @since   2014-03-31 
*/

package cryptoTrader.gui;

/**
 * this class is used as the concrete creator in the factory method for strategy B
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class ConcreteCreatorB extends Creator{
	
	/**
	* creates the concrete strategies for each broker
	* 
	* @param brokerName the name of the broker
	* @return Strategy the specific strategy to create 
	*/
	public Strategy factoryMethod(String brokerName) {
		return new StrategyB(brokerName);
	}

}
