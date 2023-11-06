package interface_adapter.single_stock.tabular;

import interface_adapter.ViewManagerModel;
import interface_adapter.single_stock.SingleStockViewModel;
import use_case.single_stock.SingleStockOutputBoundary;
import use_case.single_stock.SingleStockOutputData;

public class SingleStockTabularPresenter implements SingleStockOutputBoundary {
    private final SingleStockViewModel singleStockViewModel;
    private final ViewManagerModel viewManagerModel;

    public SingleStockTabularPresenter(SingleStockViewModel singleStockViewModel, ViewManagerModel viewManagerModel) {
        this.singleStockViewModel = singleStockViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView(SingleStockOutputData data) {
        SingleStockTabularState state = new SingleStockTabularState(data.getTitle(),
                data.getCurrentPrice(), data.getDetails(), data.getData());
        singleStockViewModel.setState(state);
        singleStockViewModel.firePropertyChanged();
        viewManagerModel.setActiveView("tabular");
        viewManagerModel.firePropertyChanged();
    }
}
