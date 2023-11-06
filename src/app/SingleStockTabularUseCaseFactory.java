package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.single_stock.SingleStockViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularController;
import interface_adapter.single_stock.tabular.SingleStockTabularPresenter;
import use_case.single_stock.SingleStockInputBoundary;
import use_case.single_stock.SingleStockInteractor;
import use_case.single_stock.SingleStockOutputBoundary;
import view.SingleStockTabularView;

public class SingleStockTabularUseCaseFactory {
    public static SingleStockTabularView create(ViewManagerModel viewManagerModel,
                                                SingleStockViewModel singleStockViewModel,
                                                APIDataAccess apiDataAccessInterface) {
        SingleStockTabularController singleStockController = createSingleStockTabularUseCase(viewManagerModel,
                singleStockViewModel, apiDataAccessInterface);
        return new SingleStockTabularView(singleStockViewModel, singleStockController, new MenuController());
    }

    public static SingleStockTabularController createSingleStockTabularUseCase(ViewManagerModel viewManagerModel,
                                                                  SingleStockViewModel singleStockViewModel,
                                                                  APIDataAccess apiDataAccessInterface) {
        SingleStockOutputBoundary singleStockOutputBoundary = new SingleStockTabularPresenter(singleStockViewModel, viewManagerModel);
        SingleStockInputBoundary singleStockInteractor = new SingleStockInteractor(singleStockOutputBoundary, apiDataAccessInterface);
        return new SingleStockTabularController(singleStockInteractor);
    }
}
