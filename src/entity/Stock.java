package entity;

import java.util.*;

/**
 * Represent a stock.
 */
public class Stock {
    private final String symbol;
    private String name;
    private String exchange;
    private String currency;
    private String country;
    private String type;
    private Float currentPrice;
    private HistoricalPrice historicalPrice;

    public Stock(String symbol) {
        this.symbol = symbol;
    }

    public void setInfo(String name, String exchange, String currency, String country, String type) {
        this.name = name;
        this.exchange = exchange;
        this.currency = currency;
        this.country = country;
        this.type = type;
    }


    /**
     * @return the Map<String, Object[]> that store all the historical price of the stock
     *         the key of the Map are date, volume, open, high, low and close
     *         the value of date is String[] that store the date of each historical price in the form yyyy-MM-dd
     *         the value of volume is Integer[] that store the number of stock trades of each historical price
     *         the value of each price is  Float[] that store the corresponding price of each historical price
     *         the values with the same index correspond to the price from same date
     */
    public Map<String, Object[]> getHistoricalPrice() {
        return historicalPrice.getPrices();
    }

    /**
     * @return the stock symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @return the real time price of the current stock
     */
    public float getCurrentPrice() {
        return currentPrice;
    }

    public String getName() {
        return name;
    }

    public String getExchange() {
        return exchange;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCountry() {
        return country;
    }

    public String getType() {
        return type;
    }

    /**
     * Set the real time price of the current stock
     * @param currentPrice the real time price of the current stock in float
     */
    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setHistoricalPrice(HistoricalPrice historicalPrice) {
        this.historicalPrice = historicalPrice;
    }

    public void reset() {
        currentPrice = null;
        historicalPrice = null;
    }

}