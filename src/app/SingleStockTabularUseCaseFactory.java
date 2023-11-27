package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockPresenter;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import use_case.single_stock.SingleStockInputBoundary;
import use_case.single_stock.SingleStockInteractor;
import use_case.single_stock.SingleStockOutputBoundary;
import view.SingleStockTabularView;

public class SingleStockTabularUseCaseFactory {
    public static SingleStockTabularView createTabular(ViewManagerModel viewManagerModel,
                                                       MenuViewModel menuViewModel,
                                                       SingleStockTabularViewModel singleStockTabularViewModel,
                                                       SingleStockGraphicalViewModel singleStockGraphicalViewModel,
                                                       APIDataAccess apiDataAccessObject) {
        SingleStockController singleStockController = SingleStockGraphicalUseCaseFactory.createSingleStockGraphicalUseCase(viewManagerModel,
                singleStockGraphicalViewModel, apiDataAccessObject);
        MenuController menuController = MenuUseCaseFactory.createMenuController(menuViewModel, viewManagerModel);
        return new SingleStockTabularView(singleStockTabularViewModel, singleStockController, menuController);
    }

    public static SingleStockController createSingleStockTabularUseCase(ViewManagerModel viewManagerModel,
                                                                  SingleStockTabularViewModel singleStockViewModel,
                                                                  APIDataAccess apiDataAccessObject) {
        SingleStockOutputBoundary singleStockOutputBoundary = new SingleStockPresenter(singleStockViewModel,
                viewManagerModel);
        SingleStockInputBoundary singleStockInteractor = new SingleStockInteractor(singleStockOutputBoundary, apiDataAccessObject);
        return new SingleStockController(singleStockInteractor);
    }

}
