package interface_adapter.single_stock;

public class SingleStockState {
    private final String symbol;
    private final String title;
    private final String currentPrice;
    private final String detail;

    public SingleStockState(String symbol, String title, String currentPrice, String detail) {
        this.symbol = symbol;
        this.title = title;
        this.currentPrice = currentPrice;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public String getDetail() {
        return detail;
    }

    public String getSymbol() {
        return symbol;
    }
}
