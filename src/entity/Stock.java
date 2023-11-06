package entity;

import java.util.HashMap;

public class Stock {
    private String name;
    private String symbol;
    private String exchange;
    private String currency;
    private String country;
    private String type;
    private float currentPrice;
    private StockPrice[] historicalPrice;

    public Stock(String name, String symbol, String exchange, String currency, String country, String type) {
        this.name = name;
        this.symbol = symbol;
        this.exchange = exchange;
        this.currency = currency;
        this.country = country;
        this.type = type;
    }

    public HashMap<String, Object[]> getHistoricalPrices() {
        int length = historicalPrice.length;

        HashMap<String, Object[]> data = new HashMap<>();
        data.put("date", new String[length]);
        data.put("open", new Float[length]);
        data.put("close", new Float[length]);
        data.put("high", new Float[length]);
        data.put("low", new Float[length]);
        data.put("volume", new Integer[length]);

        for (int i = 0; i < historicalPrice.length; i++) {
            StockPrice price = historicalPrice[i];
            data.get("date")[i] = price.getDate();
            data.get("open")[i] = price.getOpen();
            data.get("close")[i] = price.getClose();
            data.get("high")[i] = price.getHigh();
            data.get("low")[i] = price.getLow();
            data.get("volume")[i] = price.getVolume();

        }
        return data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setHistoricalPrice(StockPrice[] historicalPrice) {
        this.historicalPrice = historicalPrice;
    }
}
