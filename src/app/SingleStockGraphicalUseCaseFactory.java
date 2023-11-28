package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockViewModel;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import view.SingleStockGraphicalView;

import java.util.HashMap;
import java.util.Map;

public class SingleStockGraphicalUseCaseFactory {
    public static SingleStockGraphicalView createGraphical(ViewManagerModel viewManagerModel,
                                                           MenuViewModel menuViewModel,
                                                           Map<String, SingleStockViewModel> singleStockViewModels,
                                                           APIDataAccess apiDataAccessObject) {
        singleStockViewModels = new HashMap<>(singleStockViewModels);
        SingleStockGraphicalViewModel singleStockGraphicalViewModel = (SingleStockGraphicalViewModel) singleStockViewModels.remove("Graph");
        Map<String, SingleStockController> singleStockControllers = SingleStockUseCaseFactory.createSingleStockUsecase(viewManagerModel,
                singleStockViewModels, apiDataAccessObject);
        MenuController menuController = MenuUseCaseFactory.createMenuController(viewManagerModel, menuViewModel);
        return new SingleStockGraphicalView(singleStockGraphicalViewModel, singleStockControllers, menuController);
    }
}