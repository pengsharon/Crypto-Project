package cryptoTrader.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 * This class is primarily used to fetch the current price of the coins to be used in strategy computation
 * @author nicklam, sharon peng, nicole han, deanna chen
 *
 */
public class DataFetcher {

	/**
	 * provided code that returns json file of the coin data to be searched for prices
	 * @param id - coin 
	 * @param date - current date
	 * @return json file of the coin data
	 */
	private JsonObject getDataForCrypto(String id, String date) {

		String urlString = String.format(
				"https://api.coingecko.com/api/v3/coins/%s/history?date=%s", id, date);
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				JsonObject jsonObject = new JsonParser().parse(inline).getAsJsonObject();
				return jsonObject;
			}

		} catch (IOException e) {
			System.out.println("Something went wrong with the API call.");
		}
		return null;
	}
	
	/**
	 * helper method that converts the coin tickers into actual coin names for price fetching
	 * @param id - coin ticker
	 * @return converted string
	 */
	private String converter(String id) {
		if (id.equals("BTC")) {
			return "bitcoin";
		}
		else if (id.equals("ETH")) {
			return "ethereum";
		}
		else if (id.equals("ADA")) {
			return "cardano";
		}
		else if (id.equals("XRP")) {
			return "ripple";
		}
		else if (id.equals("DOGE")) {
			return "dogecoin";
		}
		else if (id.equals("TRX")) {
			return "tron";
		}
		return null;
	}
	
	public double getPriceForCoin(String id, String date) {
		double price = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(converter(id), date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("current_price").getAsJsonObject();
			price = currentPrice.get("cad").getAsDouble();
		}
		
		return price;
	}
	
	public double getMarketCapForCoin(String id, String date) {
		double marketCap = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(converter(id), date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("market_cap").getAsJsonObject();
			marketCap = currentPrice.get("cad").getAsDouble();
		}
		
		return marketCap;
	}
	
	public double getVolumeForCoin(String id, String date) {
		double volume = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(converter(id), date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("total_volume").getAsJsonObject();
			volume = currentPrice.get("cad").getAsDouble();
		}
		
		return volume;
	}
	
	public static void main(String[] args) {
		DataFetcher fetcher = new DataFetcher();
		double price = fetcher.getPriceForCoin("bitcoin", "08-09-2021");
		double marketCap = fetcher.getMarketCapForCoin("bitcoin", "08-09-2021");
		double volume = fetcher.getVolumeForCoin("bitcoin", "08-09-2021");
		
		System.out.println("Bitcoin=>\tPrice: " + price + 
								"\n\t\tMarket Cap: " + marketCap + 
								"\n\t\tVolume: "+volume);
		
	}
}
