package use_case.single_stock;

/**
 * the OutputBoundary for the SingleStock usecase
 */
public interface SingleStockOutputBoundary {
    // Two different implementation to trigger a visualization of our data
    // Following the strategy design pattern

    /**
     * prepare a visualization of the stock using the data provided
     * @param data the data of a stock that required for visualization
     */
    void prepareView(SingleStockOutputData data);
}
