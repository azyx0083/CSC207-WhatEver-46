package interface_adapter.single_stock;

import use_case.single_stock.SingleStockInputBoundary;
import use_case.single_stock.SingleStockInputData;

/**
 * Controller for SingleStock usecase
 */
public class SingleStockController {
    SingleStockInputBoundary singleStockUseCaseInteractor;

    /**
     * Initialize a SingleStockController
     * @param singleStockUseCaseInteractor the interactor for SingleStock usecase
     */
    public SingleStockController(SingleStockInputBoundary singleStockUseCaseInteractor) {
        this.singleStockUseCaseInteractor = singleStockUseCaseInteractor;
    }

    /**
     * execute the SingleStockInteractor to visualize a stock
     * @param symbol the stock symbol of the stock that need to be visualized
     */
    public void execute(String symbol) {
        SingleStockInputData inputData = new SingleStockInputData(symbol);
        singleStockUseCaseInteractor.execute(inputData);
    }
}
