/**
* The Creator an abstract class that has the abstract factoryMethod 
*
* @author  Deanna Chen, Nicole Han, Nick Lam, Sharon Peng
* @version 1.0
* @since   2014-03-31 
*/

package cryptoTrader.gui;

public abstract class Creator {
	
	public abstract Strategy factoryMethod(String brokerName);

}
