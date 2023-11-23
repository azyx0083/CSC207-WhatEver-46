package entity;

import java.util.Map;

/**
 * A data structure that store the historical prices of a stock
 */
public class HistoricalPrice {
    private final Map<String, Object[]> prices;
    /**
     * Initialize a Historical price with n distinct prices
     * @param n the number of historical price that need to be stored
     */
    public HistoricalPrice(int n) {
        prices = Map.of("date", new Object[n], "open", new Object[n], "close", new Object[n],
                "high", new Object[n], "low", new Object[n], "volume", new Object[n]);
    }
    /**
     * Add a new price with index i. Assume i < n (the total number of prices)
     * @param i the index of the price
     * @param date the date of the price in yyyy-MM-dd format
     * @param open the open price of the day
     * @param close the close price of the day
     * @param high the highest price of the day
     * @param low the lowest price of the day
     * @param volume the number of stock trade of the day
     */
    public void addPrice(int i,String date, float open, float close, float high, float low, int volume) {
        this.prices.get("date")[i] = date;
        this.prices.get("open")[i] = open;
        this.prices.get("close")[i] = close;
        this.prices.get("high")[i] = high;
        this.prices.get("low")[i] = low;
        this.prices.get("volume")[i] = volume;
    }
    /**
     * @return the historical price data as a map
     * the key of the Map are date, volume, open, high, low and close
     * the value of date is String[] that store the date of each historical price in the form yyyy-MM-dd
     * the value of volume is Integer[] that store the number of stock trades of each historical price
     * the value of each price is  Float[] that store the corresponding price of each historical price
     * the values with the same index correspond to the price from same date
     */
    public Map<String, Object[]> getPrices() {
        return this.prices;
    }
}
