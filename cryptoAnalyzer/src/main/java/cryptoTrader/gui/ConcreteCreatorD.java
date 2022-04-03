package cryptoTrader.gui;

public class ConcreteCreatorD extends Creator{
	
	public Strategy factoryMethod(String brokerName) {
		return new StrategyD(brokerName);
	}

}
