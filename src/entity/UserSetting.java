package entity;

import java.util.Map;

public class UserSetting {
    private final Map<String, Stock> favouriteStocks;
    private String interval;
    private int outputSize;

    public UserSetting(Map<String, Stock> favouriteStocks, String interval, int outputSize) {
        this.favouriteStocks = favouriteStocks;
        this.interval = interval;
        this.outputSize = outputSize;
    }

    public Map<String, Stock> getFavouriteStocks() {
        return favouriteStocks;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public int getOutputSize() {
        return outputSize;
    }

    public void setOutputSize(int outputSize) {
        this.outputSize = outputSize;
    }

    public void addFavouriteStock(Stock stock) {
        favouriteStocks.put(stock.getSymbol(), stock);
    }

    public void reset() {
        for (Stock stock : favouriteStocks.values()) {
            stock.reset();
        }
    }

}
