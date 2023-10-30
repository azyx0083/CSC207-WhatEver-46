package interface_adapter.single_stock;

import use_case.single_stock.SingleStockInputBoundary;

public class SingleStockController {
    SingleStockInputBoundary singleStockUseCaseInteractor;

    public SingleStockController(SingleStockInputBoundary singleStockUseCaseInteractor) {
        this.singleStockUseCaseInteractor = singleStockUseCaseInteractor;
    }

    public void execute(String symbol, String mode) {
        singleStockUseCaseInteractor.execute(symbol, mode);
    }
}
