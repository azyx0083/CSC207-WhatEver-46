package interface_adapter.single_stock;

import java.util.Map;

/**
 * Data structure that required for stock data visualization
 */
public interface SingleStockData {
    /**
     * update the SingleStockData
     * @param data the new data
     */
    void updateData(Map<String, Object[]> data);
}
