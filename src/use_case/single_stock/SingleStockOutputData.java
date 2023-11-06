package use_case.single_stock;

import java.util.HashMap;

public class SingleStockOutputData {
    private final String title;
    private final String currentPrice;
    private final String details;

    private final HashMap<String, Object[]> data;

    public SingleStockOutputData(String name, String symbol, float currentPrice,
                                 String currency, String exchange, String country, String type,
                                 HashMap<String, Object[]> data) {
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

    public HashMap<String, Object[]> getData() {
        return data;
    }
}
