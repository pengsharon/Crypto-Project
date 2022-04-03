package cryptoTrader.gui;

public class ConcreteCreatorD extends Creator{
	
	public Strategy factoryMethod() {
		return new StrategyD();
	}

}
