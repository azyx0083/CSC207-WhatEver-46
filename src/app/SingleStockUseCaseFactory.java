package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;

import java.util.ArrayList;
import java.util.List;

public class SingleStockUseCaseFactory {
    public static List<SingleStockController> createSingleStockUsecase(ViewManagerModel viewManagerModel,
                                                                       SingleStockTabularViewModel singleStockTabularViewModel,
                                                                       SingleStockGraphicalViewModel singleStockGraphicalViewModel,
                                                                       APIDataAccess apiDataAccess) {
        SingleStockController graphicalController = SingleStockGraphicalUseCaseFactory.createSingleStockGraphicalUseCase(viewManagerModel, singleStockGraphicalViewModel, apiDataAccess);
        SingleStockController tabularController = SingleStockTabularUseCaseFactory.createSingleStockTabularUseCase(viewManagerModel, singleStockTabularViewModel, apiDataAccess);
        List<SingleStockController> controllers = new ArrayList<>();
        controllers.add(tabularController);
        controllers.add(graphicalController);
        return controllers;
    }
}
