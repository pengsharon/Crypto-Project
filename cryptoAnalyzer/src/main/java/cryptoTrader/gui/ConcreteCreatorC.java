package cryptoTrader.gui;

/**
 * this class is used as the concrete creator in the factory method for strategy C
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class ConcreteCreatorC extends Creator{
	
	/**
	 * this method defines the factory method for strategy C
	 * @param brokerName - name of the broker
	 * @return a object of Strategy C
	 */
	public Strategy factoryMethod(String brokerName) {
		return new StrategyC(brokerName);
	}

}
