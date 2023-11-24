package use_case.single_stock;

import java.util.Map;

/**
 * The data structure that store all the information required for stock visualization
 */
public class SingleStockOutputData {
    private final String symbol;
    private final String title;
    private final String currentPrice;
    private final String details;
    private final Map<String, Object[]> data;

    /**
     * Initialize the data structure that all the information required for stock visualization
     * @param name the name of the stock
     * @param symbol the valid symbol of the stock all capitalized
     * @param currentPrice the current price of the stock
     * @param currency the currency of the current price
     * @param exchange the stock market exchange of the stock
     * @param country the country of the stock market exchange
     * @param type the type of the stock
     * @param data the Map<String, Object[]> that store all the historical price of the stock
     *             the key of the Map are date, volume, open, high, low and close
     *             the value of date is String[] that store the date of each historical price in the form yyyy-MM-dd
     *             the value of volume is Integer[] that store the number of stock trades of each historical price
     *             the value of each price is  Float[] that store the corresponding price of each historical price
     *             the values with the same index represent the same historical price
     */
    public SingleStockOutputData(String name, String symbol, float currentPrice,
                                 String currency, String exchange, String country, String type,
                                 Map<String, Object[]> data) {
        this.symbol = symbol;
        this.title = String.format("%s-%s", symbol, name);
        this.currentPrice = String.format("%s %s", currentPrice, currency);
        this.details = String.format("%s | %s | %s", exchange, country, type);
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
    public String getDetails() {
        return details;
    }

    /**
     * @return the Map<String, Object[]> that store all the historical price of the stock
     *         key of the Map are date, volume, open, high, low and close
     *         the value of date is String[] that store the date of each historical price in the form yyyy-MM-dd
     *         the value of volume is Integer[] that store the number of stock trades of each historical price
     *         the value of each price is  Float[] that store the corresponding price of each historical price
     *         the values with the same index represent the same historical price
     */
    public Map<String, Object[]> getData() {
        return data;
    }

    /**
     * @return return the valid symbol of the stock all capitalized
     */
    public String getSymbol() {
        return symbol;
    }
}
