package interface_adapter.single_stock;

public class SingleStockState {
    private String title;
    private String currentPrice;
    private String Detail;

    public SingleStockState(String title, String currentPrice, String detail) {
        this.title = title;
        this.currentPrice = currentPrice;
        Detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }
}
