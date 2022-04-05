package cryptoTrader.gui;

/**
 * this class is used as the concrete creator in the factory method for strategy B
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class ConcreteCreatorB extends Creator{
	
	/**
	 * this method defines the factory method for strategy B
	 * @param brokerName - name of the broker
	 * @return a object of Strategy b
	 */
	public Strategy factoryMethod(String brokerName) {
		return new StrategyB(brokerName);
	}

}
