package cryptoTrader.gui;

public class brokerInfo {
	
	private String brokerName;
	private String stratName;
	private String[] coinList;
	
	public brokerInfo(String brokerName, String[] coinList, String stratName) {
		this.brokerName = brokerName;
		this.coinList = coinList;
		this.stratName = stratName;
	}
	
	public String getBName() {
		return brokerName;
	}
	
	public String[] getCoinList() {
		return coinList;
	}
	
	public String getStratName() {
		return stratName;
	}
	
	// setters not necessary

}
