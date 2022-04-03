package cryptoTrader.gui;

public class ConcreteCreatorC extends Creator{
	
	public Strategy factoryMethod() {
		return new StrategyC();
	}

}
