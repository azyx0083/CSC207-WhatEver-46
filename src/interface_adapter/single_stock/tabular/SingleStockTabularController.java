package interface_adapter.single_stock.tabular;

import use_case.single_stock.tabular.SingleStockTabularInputBoundary;

public class SingleStockTabularController {
    SingleStockTabularInputBoundary singleStockTabularUseCaseInteractor;

    public SingleStockTabularController(SingleStockTabularInputBoundary singleStockUseCaseInteractor) {
        this.singleStockTabularUseCaseInteractor = singleStockUseCaseInteractor;
    }

    public void execute() {
        singleStockTabularUseCaseInteractor.execute();
    }
}
