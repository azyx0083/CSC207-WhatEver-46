package interface_adapter.single_stock;

public class SingleStockState {
    private final String title;
    private final String currentPrice;
    private final String detail;

    public SingleStockState(String title, String currentPrice, String detail) {
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
}
