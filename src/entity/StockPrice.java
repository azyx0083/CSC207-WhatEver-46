package entity;

/**
 * Represent a stock price on a specific date.
 */
public class StockPrice {
    private final String date;
    private final float high;
    private final float low;
    private final float open;
    private final float close;
    private final int volume;

    /**
     * Initializing a StockPrice
     * @param date the date of the price
     * @param high the highest price of the day
     * @param low the lowest price of the day
     * @param open the open price of the day
     * @param close the close price of the day
     * @param volume the number of share traded on the date
     */
    public StockPrice(String date, float high, float low, float open, float close, int volume) {
        this.date = date;
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    /**
     *
     * @return the date of the price
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @return the highest price of the day
     */
    public float getHigh() {
        return high;
    }

    /**
     *
     * @return the lowest price of the day
     */
    public float getLow() {
        return low;
    }

    /**
     *
     * @return the open price of the day
     */
    public float getOpen() {
        return open;
    }

    /**
     *
     * @return the close price of the day
     */
    public float getClose() {
        return close;
    }

    /**
     *
     * @return the number of shares traded on the date
     */
    public int getVolume() {
        return volume;
    }
}
