package cryptoTrader.gui;

public class ConcreteCreatorA extends Creator {
	
	public Strategy factoryMethod() {
		return new StrategyA();
	}

}
