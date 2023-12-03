package interface_adapter.single_stock;

import interface_adapter.ViewManagerModel;
import use_case.single_stock.SingleStockOutputBoundary;
import use_case.single_stock.SingleStockOutputData;

/**
 * The presenter for SingleStock usecase
 */
public class SingleStockPresenter implements SingleStockOutputBoundary {
    private final SingleStockViewModel singleStockViewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Initialize a SingleStockPresenter
     * @param singleStockViewModel the ViewModel that store all information required to prepare a SingleStockView
     * @param viewManagerModel the ViewModel that trigger the switch to a new view
     */
    public SingleStockPresenter(SingleStockViewModel singleStockViewModel, ViewManagerModel viewManagerModel) {
        this.singleStockViewModel = singleStockViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * prepare the visualization of stock data
     * @param data the data of a stock that required for visualization
     */
    public void prepareView(SingleStockOutputData data) {
        SingleStockState state = singleStockViewModel.getState();
        // SingleStockPresenter only depends on the SingleStockPriceData interface not the concrete implementation
        // The different data structure adapters implement the SingleStockPriceData interface
        // Apply Adapter design pattern
        singleStockViewModel.setState(new SingleStockState(data.getSymbol(), data.getTitle(), data.getCurrentPrice(),
                data.getDetails(), state.getData().updateData(data.getData())));
        singleStockViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singleStockViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
