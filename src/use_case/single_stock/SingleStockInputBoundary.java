package use_case.single_stock;

/**
 * InputBoundary for the SingleStock usecase
 */
public interface SingleStockInputBoundary {
    /**
     * Let the interactor execute the SingleStock usecase using the given symbol
     * @param symbol a valid stock symbol
     */
    void execute(String symbol);
}
