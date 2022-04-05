/**
* The ConcreateCreatorD implements a class that extends from Creator 
* to create StrategyD object with the factoryMethod
*
* @author  Deanna Chen, Nicole Han, Nick Lam, Sharon Peng
* @version 1.0
* @since   2014-03-31 
*/

package cryptoTrader.gui;

/**
 * this class is used as the concrete creator in the factory method for strategy C
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class ConcreteCreatorD extends Creator{
	
	/**
	 * this method defines the factory method for strategy D
	 * @param brokerName - name of the broker
	 * @return a object of Strategy D
	 */
	public Strategy factoryMethod(String brokerName) {
		return new StrategyD(brokerName);
	}

}
