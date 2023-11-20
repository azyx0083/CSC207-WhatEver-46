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
    private final SingleStockStateUpdater updater;

    /**
     * Initialize a SingleStockPresenter
     * @param singleStockViewModel the ViewModel that store all information required to prepare a SingleStockView
     * @param viewManagerModel the ViewModel that trigger the switch to a new view
     * @param updater the SingleStockStateSetter that update the information required to prepare the view
     */
    public SingleStockPresenter(SingleStockViewModel singleStockViewModel, ViewManagerModel viewManagerModel,
                                SingleStockStateUpdater updater) {
        this.singleStockViewModel = singleStockViewModel;
        this.viewManagerModel = viewManagerModel;
        this.updater = updater;
    }

    /**
     * prepare the visualization of stock data
     * @param data the data of a stock that required for visualization
     */
    public void prepareView(SingleStockOutputData data) {
        SingleStockState state = singleStockViewModel.getState();
        updater.updateState(data, state);
        singleStockViewModel.setState(state);
        singleStockViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singleStockViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
