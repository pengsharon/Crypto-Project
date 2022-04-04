/**
* The ConcreateCreatorD implements a class that extends from Creator 
* to create StrategyD object with the factoryMethod
*
* @author  Deanna Chen, Nicole Han, Nick Lam, Sharon Peng
* @version 1.0
* @since   2014-03-31 
*/

package cryptoTrader.gui;

public class ConcreteCreatorD extends Creator{
	
	public Strategy factoryMethod(String brokerName) {
		return new StrategyD(brokerName);
	}

}
