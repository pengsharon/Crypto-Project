package cryptoTrader.gui;

public class ConcreteCreatorC extends Creator{
	
	public Strategy factoryMethod(String brokerName) {
		return new StrategyC(brokerName);
	}

}
