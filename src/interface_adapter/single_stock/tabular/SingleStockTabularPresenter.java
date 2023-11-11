package interface_adapter.single_stock.tabular;

import interface_adapter.ViewManagerModel;
import use_case.single_stock.SingleStockOutputBoundary;
import use_case.single_stock.SingleStockOutputData;

public class SingleStockTabularPresenter implements SingleStockOutputBoundary {
    private final SingleStockTabularViewModel singleStockViewModel;
    private final ViewManagerModel viewManagerModel;

    public SingleStockTabularPresenter(SingleStockTabularViewModel singleStockViewModel, ViewManagerModel viewManagerModel) {
        this.singleStockViewModel = singleStockViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView(SingleStockOutputData data) {
        SingleStockTabularState state = new SingleStockTabularState(data.getSymbol(), data.getTitle(),
                data.getCurrentPrice(), data.getDetails(), data.getData());
        singleStockViewModel.setState(state);
        singleStockViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singleStockViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
