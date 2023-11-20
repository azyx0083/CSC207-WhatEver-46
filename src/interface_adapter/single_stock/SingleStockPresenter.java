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
        state.setSymbol(data.getSymbol());
        state.setTitle(data.getTitle());
        state.setCurrentPrice(data.getCurrentPrice());
        state.setDetail(data.getDetails());
        // SingleStockPresenter only depends on the SingleStockData interface not the concrete implementation
        // The different data structure adapters implement the SingleStockData interface
        // Apply Dependency Inversion Principle
        state.getData().updateData(data.getData());
        singleStockViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singleStockViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
