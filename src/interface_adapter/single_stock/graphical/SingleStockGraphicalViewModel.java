package interface_adapter.single_stock.graphical;

import interface_adapter.single_stock.SingleStockViewModel;

/**
 * ViewModel that store all information required to prepare SingleStockGraphicalView
 */
public class SingleStockGraphicalViewModel extends SingleStockViewModel {
    // Information required to visualize a table and a graph share the same structure except the viewName
    // Let SingleStockGraphicalViewModel extend the SingleStockViewModel allow the minimum amount of new code
    // if we want to add a new visualization of our data in the future
    // Apply the Open/Close Principle

    /**
     * Initialize the SingleStockGraphicalViewModel with viewName being graphical
     */
    public SingleStockGraphicalViewModel() {
        super("graphical");
    }
}
