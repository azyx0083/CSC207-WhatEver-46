package use_case.single_stock;

public class SingleStockOutputData {
    private final String title;
    private final String currentPrice;
    private final String details;

    public SingleStockOutputData(String name, String symbol, float currentPrice,
                                 String currency, String exchange, String country, String type) {
        this.title = String.format("%s-%s", symbol, name);
        this.currentPrice = String.format("%s %s", currentPrice, currency);
        this.details = String.format("%s | %s | %s", exchange, country, type);
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
}
