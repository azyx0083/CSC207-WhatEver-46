package entity;

public class StockPrice {
    private final String date;
    private final float high;
    private final float low;
    private final float open;
    private final float close;
    private final int volume;

    public StockPrice(String date, float high, float low, float open, float close, int volume) {
        this.date = date;
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public String getDate() {
        return date;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public float getOpen() {
        return open;
    }

    public float getClose() {
        return close;
    }

    public int getVolume() {
        return volume;
    }
}
