package cryptoTrader.gui;

/**
 * this class is used as the concrete creator in the factory method for strategy A
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class ConcreteCreatorA extends Creator {
	
	/**
	 * this method defines the factory method for strategy A
	 * @param brokerName - name of the broker
	 * @return a object of Strategy A
	 */
	public Strategy factoryMethod(String brokerName) {
		return new StrategyA(brokerName);
	}

}
