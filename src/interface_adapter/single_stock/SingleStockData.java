package interface_adapter.single_stock;

import java.util.Map;

/**
 * Data structure that required for stock data visualization
 */
public interface SingleStockData {
    // There are more than one data structure required for the visualization
    // By creating this interface, the SingleStockPresenter don't need to know the actual implementation of each data
    // structure to update the new data every time
    // If we want to add more visualization method, we only need to add more adapters that implement this interface
    // without change anything in the SingleStockState, SingleStockViewModel or SingleStockPresenter
    // All adapters may have different structure, but they all serve the same goal to help visualize the stock data
    // Apply Open/Closed Principle, Liskov Substitution Principle and Strategy design pattern

    /**
     * update the SingleStockData
     * @param data the new stock price data
     */
    SingleStockData updateData(Map<String, Object[]> data);

    // For test purpose only
    Map<String, Object[]> getDate();
}
