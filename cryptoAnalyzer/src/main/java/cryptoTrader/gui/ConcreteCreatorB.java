package cryptoTrader.gui;

public class ConcreteCreatorB extends Creator{
	
	public Strategy factoryMethod(String brokerName) {
		return new StrategyB(brokerName);
	}

}
