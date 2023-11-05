package interface_adapter.single_stock.graphical;

import use_case.single_stock.graphical.SingleStockGraphicalInputBoundary;

public class SingleStockGraphicalController {
    private final SingleStockGraphicalInputBoundary singleStockGraphicalInteractor;

    public SingleStockGraphicalController(SingleStockGraphicalInputBoundary singleStockGraphicalInteractor) {
        this.singleStockGraphicalInteractor = singleStockGraphicalInteractor;
    }

    public void execute() {
        singleStockGraphicalInteractor.execute();
    }
}
