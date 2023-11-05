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

        Object[][] data = new Object[length][6];
        data[0] = new String[]{"Date", "Open", "High", "Low", "Close", "Volume"};

        for (int i = 0; i < historicalPrice.length; i++) {
            StockPrice price = historicalPrice[i];
            data[i+1] = new Object[]{price.getDate(), price.getOpen(), price.getHigh(),
                    price.getLow(), price.getClose(), price.getVolume()};
        }
        return data;
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
