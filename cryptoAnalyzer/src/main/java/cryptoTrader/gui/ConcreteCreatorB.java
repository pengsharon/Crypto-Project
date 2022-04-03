package cryptoTrader.gui;

public class ConcreteCreatorB extends Creator{
	
	public Strategy factoryMethod() {
		return new StrategyB();
	}

}
