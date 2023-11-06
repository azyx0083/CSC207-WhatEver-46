package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.single_stock.graphical.SingleStockGraphicalController;
import interface_adapter.single_stock.graphical.SingleStockGraphicalPresenter;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularController;
import interface_adapter.single_stock.tabular.SingleStockTabularPresenter;
import use_case.single_stock.SingleStockInputBoundary;
import use_case.single_stock.SingleStockInteractor;
import use_case.single_stock.SingleStockOutputBoundary;
import view.SingleStockGraphicalView;
import view.SingleStockTabularView;

public class SingleStockUseCaseFactory {
    public static SingleStockTabularView createTabular(ViewManagerModel viewManagerModel,
                                                       SingleStockTabularViewModel singleStockTabularViewModel,
                                                       SingleStockGraphicalViewModel singleStockGraphicalViewModel,
                                                       APIDataAccess apiDataAccessObject) {
        SingleStockGraphicalController singleStockController = createSingleStockGraphicalUseCase(viewManagerModel,
                singleStockGraphicalViewModel, apiDataAccessObject);
        return new SingleStockTabularView(singleStockTabularViewModel, singleStockController, new MenuController());
    }

    public static SingleStockGraphicalView createGraphical(ViewManagerModel viewManagerModel,
                                                           SingleStockTabularViewModel singleStockTabularViewModel,
                                                           SingleStockGraphicalViewModel singleStockGraphicalViewModel,
                                                           APIDataAccess apiDataAccessObject) {
        SingleStockTabularController singleStockController = createSingleStockTabularUseCase(viewManagerModel,
                singleStockTabularViewModel, apiDataAccessObject);
        return new SingleStockGraphicalView(singleStockGraphicalViewModel, singleStockController, new MenuController());
    }

    public static SingleStockTabularController createSingleStockTabularUseCase(ViewManagerModel viewManagerModel,
                                                                  SingleStockTabularViewModel singleStockViewModel,
                                                                  APIDataAccess apiDataAccessObject) {
        SingleStockOutputBoundary singleStockOutputBoundary = new SingleStockTabularPresenter(singleStockViewModel, viewManagerModel);
        SingleStockInputBoundary singleStockInteractor = new SingleStockInteractor(singleStockOutputBoundary, apiDataAccessObject);
        return new SingleStockTabularController(singleStockInteractor);
    }

    public static SingleStockGraphicalController createSingleStockGraphicalUseCase(ViewManagerModel viewManagerModel,
                                                                                   SingleStockGraphicalViewModel singleStockViewModel,
                                                                                   APIDataAccess apiDataAccessObject) {
        SingleStockOutputBoundary singleStockOutputBoundary = new SingleStockGraphicalPresenter(singleStockViewModel, viewManagerModel);
        SingleStockInputBoundary singleStockInputBoundary = new SingleStockInteractor(singleStockOutputBoundary, apiDataAccessObject);
        return new SingleStockGraphicalController(singleStockInputBoundary);
    }
}
