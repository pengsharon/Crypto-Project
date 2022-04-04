# Crypto-Project

Welcome to the Crypto-Project trader

To begin, run LoginUI to login and verify credentials. If you are a valid user, you will be taken to the MainUI page.

User credentials are strored in format: username,password
--> For example: sharon,pg123

These credentials are stored in "credentials.txt" and can be modified by adding more login users or removing some.

Once taken to the mainUI page, you can perform trades and add rows as you please.

Strategy description:
A) If BTC coin price > 14*ETH coin price, buy 500 ETH coin, otherwise sell 1 BTC
B) If ETH price > 1000*DOGE coin price, buy 100 DOGE, otherwise sell 200 DOGE
C) ADA, XRP, buy cheapest (50x)
D) DOGE, TRX, sell most expensive (200x) 


Coins used are:
ETH, BTC, ADA, DOGE, XRP, TRX

To add more coins, go to DataFetcher.java and add in the converter method.
