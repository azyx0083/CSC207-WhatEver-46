package interface_adapter.single_stock.graphical;

import use_case.single_stock.SingleStockInputBoundary;

public class SingleStockGraphicalController {
    private final SingleStockInputBoundary singleStockGraphicalInteractor;

    public SingleStockGraphicalController(SingleStockInputBoundary singleStockGraphicalInteractor) {
        this.singleStockGraphicalInteractor = singleStockGraphicalInteractor;
    }

    public void execute(String symbol) {
        singleStockGraphicalInteractor.execute(symbol);
    }
}
