package use_case.single_stock;

import java.util.Map;

public class SingleStockOutputData {
    private final String symbol;
    private final String title;
    private final String currentPrice;
    private final String details;

    private final Map<String, Object[]> data;

    public SingleStockOutputData(String name, String symbol, float currentPrice,
                                 String currency, String exchange, String country, String type,
                                 Map<String, Object[]> data) {
        this.symbol = symbol;
        this.title = String.format("%s-%s", symbol, name);
        this.currentPrice = String.format("%s %s", currentPrice, currency);
        this.details = String.format("%s | %s | %s", exchange, country, type);
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public String getDetails() {
        return details;
    }

    public Map<String, Object[]> getData() {
        return data;
    }

    public String getSymbol() {
        return symbol;
    }
}
