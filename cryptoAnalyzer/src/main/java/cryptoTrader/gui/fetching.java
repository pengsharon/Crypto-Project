package cryptoTrader.gui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.*;
import java.util.Enumeration;

import cryptoTrader.utils.DataFetcher;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class fetching {
	
	
	public static void main(String[] args) {
		Hashtable<String, Double> coin_prices = new Hashtable<String, Double>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println(dtf.format(now));
		DataFetcher fetch_price = new DataFetcher();
		ArrayList<String> coinsToFetch = new ArrayList<String>();
		coinsToFetch.add("BTC");
		coinsToFetch.add("ETH");
		
		
		for (String s : coinsToFetch) {
			System.out.println(s);
		}
		
		for (String s : coinsToFetch) {
			double price = fetch_price.getPriceForCoin(s, dtf.format(now));
			coin_prices.put(s, price);
		}
		
		Enumeration<String> e = coin_prices.keys();
		
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			System.out.println("Key: " + key + "\t\t Price: " + coin_prices.get(key));
		}
		
		
		
	}
	
}
