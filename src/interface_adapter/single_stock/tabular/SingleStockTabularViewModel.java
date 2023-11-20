package interface_adapter.single_stock.tabular;

import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.SingleStockViewModel;

/**
 * ViewModel that store all information required to prepare SingleStockTabularView
 */
public class SingleStockTabularViewModel extends SingleStockViewModel {
    // Information required to visualize a stock share the same structure except the viewName and required data structure for historical price
    // If we want to add a new visualization of our data in the future, current implementation only required a new adapter
    // for the required data structure and a sub viewModel that specify the viewName
    // Apply the Open/Closed Principle

    /**
     * Initialize the viewName and state of the SingleStockTabularViewModel
     */
    public SingleStockTabularViewModel() {
        super("tabular", new SingleStockState(new StockPriceTableModel()));
    }
}
