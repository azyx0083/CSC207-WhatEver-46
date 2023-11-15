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
     * Set the name, currency, country and type for the current stock.
     * @param name the stock's official name in String
     * @param currency the stock's currency in current stock market exchange in String
     * @param country the country for the current stock in String
     * @param type the type of the stock in String, eg: "common stock"
     */
    public void setInfo(String name, String currency, String country, String type) {
        this.name = name;
        this.currency = currency;
        this.country = country;
        this.type = type;
    }

    /**
     *
     * @return the historicalPrice of current stock in the form of HashMap. The key value pairs are: "date" and String[]
     * with dates in the form yyyy-MM-dd; "open" and Float[] with open prices correspond to each date; "close" and
     * Float[] with close price correspond to each date; "high" and Float[] with high price correspond to each date;
     * "low" and Float[] with low price correspond to each date; "volume" and Integer[] with volume amount correspond
     * to each date.
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
     * Set the stock market exchange for the current stock
     * @param exchange a valid stock market exchange in String
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
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
     * Set the real time price for the current stock
     * @param currentPrice the real time price of the current stock in float
     */
    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * update the historical prices of the current stock using the list of stock price provided
     * @param historicalPrice the historical prices of the current price in StockPrice[]
     */
    public void update(List<StockPrice> historicalPrice) {
        // application of dependency injection design patter
        // create the list of StockPrice outside of Stock and update them all at once
        this.historicalPrice = historicalPrice;
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
