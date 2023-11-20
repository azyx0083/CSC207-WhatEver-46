package interface_adapter.single_stock;

/**
 * The data structure that store the specific data for a stock (subject to changes)
 */
public class SingleStockState {
    private String symbol = "";
    private String title = "";
    private String currentPrice = "";
    private String detail = "";
    private SingleStockData data = null;

    /**
     * Initialize a SingleStockState
     */
    public SingleStockState() {}

    /**
     * @return the title of the stock in the form Symbol-Name
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the current price of the stock in the form CurrentPrice Currency
     */
    public String getCurrentPrice() {
        return currentPrice;
    }

    /**
     * @return the details of the stock in the form StockExchange | Country | StockType
     */
    public String getDetail() {
        return detail;
    }

    /**
     *
     * @return the symbol of the stock
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     *
     * @return a SingleStockData that store the historical price of the stock
     */
    public SingleStockData getData() {
        return data;
    }

    /**
     * Set the stock symbol
     * @param symbol the new stock symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Set the title
     * @param title the new title in the form Symbol-Name
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set the current price
     * @param currentPrice the new current price in the form CurrentPrice Currency
     */
    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * Set the detail
     * @param detail the new detail in the form StockExchange | Country | StockType
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * Set the SingleStockData
     * @param data the SingleStockData that required for visualization
     */
    public void setData(SingleStockData data) {
        this.data = data;
    }
}
