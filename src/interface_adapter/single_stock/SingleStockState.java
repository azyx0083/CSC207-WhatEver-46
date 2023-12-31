package interface_adapter.single_stock;

/**
 * The data structure that store the specific data for a stock (subject to changes)
 */
public class SingleStockState {
    private String symbol;
    private String title;
    private String currentPrice;
    private String detail;
    private final SingleStockPriceData data;

    /**
     * Initialize a SingleStockState
     */
    public SingleStockState(SingleStockPriceData data) {
        // Separate the functionality required for each data visualization to a new adapter class
        // Construct the SingleStockPriceData outside the SingleStockState, so they are not dependent
        // Apply Dependency Injection design pattern and Single Responsibility Principle
        this.data = data;
    }

    /**
     * Initialize a SingleStockState
     * @param symbol the stock symbol
     * @param title the title of the stock in the form Symbol-Name
     * @param currentPrice the current price of the stock in the form CurrentPrice Currency
     * @param detail the details of the stock in the form StockExchange | Country | StockType
     * @param data a SingleStockPriceData that store the historical prices of the stock
     */
    public SingleStockState(String symbol, String title, String currentPrice, String detail, SingleStockPriceData data) {
        this.symbol = symbol;
        this.title = title;
        this.currentPrice = currentPrice;
        this.detail = detail;
        this.data = data;
    }

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
     * @return a SingleStockPriceData that store the historical price of the stock
     */
    public SingleStockPriceData getData() {
        return data;
    }
}
