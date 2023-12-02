package use_case.single_stock;

/**
 * InputBoundary for the SingleStock usecase
 */
public interface SingleStockInputBoundary {
    /**
     * Let the interactor execute the SingleStock usecase using the given symbol
     *
     * @param inputData the input data from interface adapter
     */
    void execute(SingleStockInputData inputData);
}
