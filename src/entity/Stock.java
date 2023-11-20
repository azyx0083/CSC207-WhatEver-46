package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represent a stock.
 */
public class Stock {
    private String name;
    private final String symbol;
    private String exchange;
    private String currency;
    private String country;
    private String type;
    private float currentPrice;
    private List<StockPrice> historicalPrice;

    /**
     * Initializing a stock with given stock symbol.
     * @param symbol the stock's symbol all capitalized in String.
     */
    public Stock(String symbol) {
        this.symbol = symbol;
    }

    /**
     * @return the Map<String, Object[]> that store all the historical price of the stock
     *         the key of the Map are date, volume, open, high, low and close
     *         the value of date is String[] that store the date of each historical price in the form yyyy-MM-dd
     *         the value of volume is Integer[] that store the number of stock trades of each historical price
     *         the value of each price is  Float[] that store the corresponding price of each historical price
     *         the values with the same index correspond to the same StockPrice
     */
    public Map<String, Object[]> getHistoricalPrices() {
        int length = historicalPrice.size();

        Map<String, Object[]> data = new HashMap<>();
        data.put("date", new String[length]);
        data.put("open", new Float[length]);
        data.put("close", new Float[length]);
        data.put("high", new Float[length]);
        data.put("low", new Float[length]);
        data.put("volume", new Integer[length]);

        for (int i = 0; i < length; i++) {
            StockPrice price = historicalPrice.get(i);
            data.get("date")[i] = price.getDate();
            data.get("open")[i] = price.getOpen();
            data.get("close")[i] = price.getClose();
            data.get("high")[i] = price.getHigh();
            data.get("low")[i] = price.getLow();
            data.get("volume")[i] = price.getVolume();

        }
        return data;
    }

    /**
     *
     * @return the stock name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the stock symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @return the stock market exchange for the current stock
     */
    public String getExchange() {
        return exchange;
    }

    /**
     *
     * @return the currency for the current stock
     */
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @return the country for the current stock
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @return the stock type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @return the real time price of the current stock
     */
    public float getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Set the real time price of the current stock
     * @param currentPrice the real time price of the current stock in float
     */
    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * Set the stock market exchange of the current stock
     * @param exchange a valid stock market exchange in String
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * Set the stock name of the current stock
     * @param name the official stock name of the stock
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the currency of the current stock
     * @param currency the currency of the stock's current and historical prices
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Set the country of the current stock
     * @param country the country of the stock's stock market exchange
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Set the type of the current stock
     * @param type the stock type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * update the historical price of the current stock to be an empty list
     */
    public void update() {
        this.historicalPrice = new ArrayList<>();
    }

    /**
     * add the provided stock price as a historical price
     * @param stockPrice a historical stock price of the current stock
     */
    public void addPrice(StockPrice stockPrice) {
        // application of dependency injection design pattern
        // create the StockPrice object outside of Stock and inject it here
        this.historicalPrice.add(stockPrice);
    }
}
