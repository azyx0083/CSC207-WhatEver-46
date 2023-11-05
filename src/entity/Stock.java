package entity;

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
        int length = historicalPrice.length + 1;

        Object[] date = new Object[length];
        date[0] = " ";
        Object[] open = new Object[length];
        open[0] = "open price";
        Object[] close = new Object[length];
        close[0] = "close price";
        Object[] low = new Object[length];
        low[0] = "low price";
        Object[] high = new Object[length];
        high[0] = "high price";
        Object[] volume = new Object[length];
        volume[0] = "volume";

        for (int i = 1; i <= historicalPrice.length; i++) {
            date[i] = historicalPrice[i - 1].getDate();
            open[i] = historicalPrice[i - 1].getOpen();
            close[i] = historicalPrice[i - 1].getClose();
            low[i] = historicalPrice[i - 1].getLow();
            high[i] = historicalPrice[i - 1].getHigh();
            volume[i] = historicalPrice[i - 1].getVolume();
        }
        return new Object[][]{date, open, close, low, high, volume};
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
