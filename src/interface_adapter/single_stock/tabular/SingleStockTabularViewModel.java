package interface_adapter.single_stock.tabular;

import interface_adapter.single_stock.SingleStockViewModel;

/**
 * ViewModel that store all information required to prepare SingleStockTabularView
 */
public class SingleStockTabularViewModel extends SingleStockViewModel {
    // Information required to visualize a table and a graph share the same structure except the viewName
    // Let SingleStockTabularViewModel extend the SingleStockViewModel allow the minimum amount of new code
    // if we want to add a new visualization of our data in the future
    // Apply the Open/Close Principle

    /**
     * Initialize the SingleStockTabularViewModel with the viewName being tabular
     */
    public SingleStockTabularViewModel() {
        super("tabular");
    }
}
