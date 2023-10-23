package Entities;

public class StockPrice {
    private float high;
    private float low;
    private float open;
    private float close;
    private int volume;

    public StockPrice(float high, float low, float open, float close, int volume) {
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
    }

    public void update(float high, float low, float open, float close, int volume) {
        this.high = high;
        this.low = low;
        this.open = open;
        this.close = close;
        this.volume = volume;
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
