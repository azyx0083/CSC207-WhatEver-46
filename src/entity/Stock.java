package entity;

import javax.management.ObjectName;

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

    public Object[][] getHistoricalPrices() {
        Object[] open = new Object[historicalPrice.length + 1];
        open[0] = "open price";
        Object[] close = new Object[historicalPrice.length + 1];
        close[0] = "close price";
        Object[] low = new Object[historicalPrice.length + 1];
        low[0] = "low price";
        Object[] high = new Object[historicalPrice.length + 1];
        high[0] = "high price";
        Object[] volume = new Object[historicalPrice.length + 1];
        volume[0] = "volume";

        for (int i = 1; i <= historicalPrice.length; i++) {
            open[i] = historicalPrice[i - 1].getOpen();
            close[i] = historicalPrice[i - 1].getClose();
            low[i] = historicalPrice[i - 1].getLow();
            high[i] = historicalPrice[i - 1].getHigh();
            volume[i] = historicalPrice[i - 1].getVolume();
        }
        return new Object[][]{open, close, low, high, volume};
    }

    public String[] getHistoricalDates() {
        String[] dates = new String[historicalPrice.length + 1];
        dates[0] = "";
        for (int i = 1; i <= historicalPrice.length; i++) {
            dates[i] = historicalPrice[i-1].getDate();
        }
        return dates;
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

    public StockPrice[] getHistoricalPrice() {
        return historicalPrice;
    }

    public void setHistoricalPrice(StockPrice[] historicalPrice) {
        this.historicalPrice = historicalPrice;
    }
}
