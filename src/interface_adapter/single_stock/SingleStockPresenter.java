package interface_adapter.single_stock;

import interface_adapter.ViewManagerModel;
import use_case.single_stock.SingleStockGraphicalOutputData;
import use_case.single_stock.SingleStockOutputBoundary;
import use_case.single_stock.SingleStockTabularOutputData;

public class SingleStockPresenter implements SingleStockOutputBoundary {
    private SingleStockViewModel singleStockViewModel;
    private ViewManagerModel viewManagerModel;

    public SingleStockPresenter(ViewManagerModel viewManagerModel, SingleStockViewModel singleStockViewModel) {
        this.singleStockViewModel = singleStockViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareTabularView(SingleStockTabularOutputData data) {
        singleStockViewModel = new SingleStockTabularViewModel(data.getName(), data.getSymbol(),
                data.getData(), data.getColumnNames());
        singleStockViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singleStockViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareGraphicalView(SingleStockGraphicalOutputData data) {
        singleStockViewModel = new SingleStockGraphicalViewModel(data.getName(), data.getSymbol(),
                data.getDataset());
        singleStockViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(singleStockViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailedView(String error) {

    }
}
