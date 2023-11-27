package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;

import java.util.ArrayList;

public class SingleStockUseCaseFactory {
    public static ArrayList<SingleStockController> createSingleStockUsecase(ViewManagerModel viewManagerModel,
                                                                            SingleStockTabularViewModel singleStockTabularViewModel,
                                                                            SingleStockGraphicalViewModel singleStockGraphicalViewModel,
                                                                            APIDataAccess apiDataAccess) {
        SingleStockController graphicalController = SingleStockGraphicalUseCaseFactory.createSingleStockGraphicalUseCase(viewManagerModel, singleStockGraphicalViewModel, apiDataAccess);
        SingleStockController tabularController = SingleStockTabularUseCaseFactory.createSingleStockTabularUseCase(viewManagerModel, singleStockTabularViewModel, apiDataAccess);
        ArrayList<SingleStockController> controllers = new ArrayList<>();
        controllers.add(tabularController);
        controllers.add(graphicalController);
        return controllers;
    }
}
