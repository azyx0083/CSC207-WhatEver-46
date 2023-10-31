package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockPresenter;
import interface_adapter.single_stock.SingleStockTabularViewModel;
import interface_adapter.single_stock.SingleStockViewModel;
import use_case.single_stock.*;
import view.SingleStockGraphicalView;
import view.SingleStockTabularView;

public class SingleStockUseCaseFactory {
    public static SingleStockTabularView createTabular(ViewManagerModel viewManagerModel,
                                                       SingleStockTabularViewModel singleStockTabularViewModel,
                                                       SingleStockAPIDataAccessInterface apiDataAccessInterface) {
        SingleStockController singleStockController = createSingleStockUseCase(viewManagerModel, apiDataAccessInterface);
        return new SingleStockTabularView(singleStockTabularViewModel, singleStockController, new MenuController());
    }

    public SingleStockGraphicalView createGraphical(ViewManagerModel viewManagerModel, SingleStockViewModel singleStockViewModel,
                                                    SingleStockAPIDataAccessInterface apiDataAccessInterface) {
        SingleStockController singleStockController = createSingleStockUseCase(viewManagerModel, apiDataAccessInterface);
        return new SingleStockGraphicalView();
    }

    private static SingleStockController createSingleStockUseCase(ViewManagerModel viewManagerModel,
                                                                  SingleStockAPIDataAccessInterface apiDataAccessInterface) {
        SingleStockOutputBoundary singleStockOutputBoundary = new SingleStockPresenter(viewManagerModel, new SingleStockViewModel());
        SingleStockInputBoundary singleStockInteractor = new SingleStockInteractor(singleStockOutputBoundary, apiDataAccessInterface);
        return new SingleStockController(singleStockInteractor);
    }
}
