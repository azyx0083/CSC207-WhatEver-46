package interface_adapter.single_stock.graphical;

import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.SingleStockViewModel;

/**
 * ViewModel that store all information required to prepare SingleStockGraphicalView
 */
public class SingleStockGraphicalViewModel extends SingleStockViewModel {
    // Information required to visualize a stock share the same structure except the viewName and required data structure for historical price
    // If we want to add a new visualization of our data in the future, current implementation only required a new adapter
    // for the required data structure and a sub viewModel that specify the viewName
    // Apply the Open/Close Principle

    /**
     * Initialize viewName and state for the SingleStockGraphicalViewModel
     */
    public SingleStockGraphicalViewModel() {
        super("graphical", new SingleStockState(new SingleStockPriceDataset()));
    }
}
