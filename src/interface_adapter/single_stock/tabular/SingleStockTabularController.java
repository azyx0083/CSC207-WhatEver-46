package interface_adapter.single_stock.tabular;

import use_case.single_stock.SingleStockInputBoundary;

public class SingleStockTabularController {
    SingleStockInputBoundary singleStockTabularUseCaseInteractor;

    public SingleStockTabularController(SingleStockInputBoundary singleStockUseCaseInteractor) {
        this.singleStockTabularUseCaseInteractor = singleStockUseCaseInteractor;
    }

    public void execute() {
        singleStockTabularUseCaseInteractor.execute();
    }
}
