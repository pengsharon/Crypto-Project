package cryptoTrader.gui;

public class ConcreteCreatorA extends Creator {
	
	public Strategy factoryMethod(String brokerName) {
		return new StrategyA(brokerName);
	}

}
