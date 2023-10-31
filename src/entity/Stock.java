package entity;

import javax.management.ObjectName;

public class Stock {
    private String name;
    private String symbol;
    private StockPrice[] historicalPrice;

    public Stock(String name, String symbol, StockPrice[] historicalPrice) {
        this.name = name;
        this.symbol = symbol;
        this.historicalPrice = historicalPrice;
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

    public String getSymbol() {
        return symbol;
    }

    public StockPrice[] getHistoricalPriceList() {
        return historicalPrice;
    }
}
