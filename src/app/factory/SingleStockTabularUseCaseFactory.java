package app.factory;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import view.SingleStockTabularView;

import java.util.HashMap;
import java.util.Map;

public class SingleStockTabularUseCaseFactory {
    public static SingleStockTabularView createTabular(ViewManagerModel viewManagerModel,
                                                           MenuViewModel menuViewModel,
                                                           Map<String, SingleStockViewModel> singleStockViewModels,
                                                           APIDataAccess apiDataAccessObject) {
        singleStockViewModels = new HashMap<>(singleStockViewModels);
        SingleStockTabularViewModel singleStockTabularViewModel  = (SingleStockTabularViewModel) singleStockViewModels.remove("Table");
        Map<String, SingleStockController> singleStockControllers = SingleStockUseCaseFactory.createSingleStockUsecase(viewManagerModel,
                singleStockViewModels, apiDataAccessObject);
        MenuController menuController = MenuUseCaseFactory.createMenuController(viewManagerModel, menuViewModel);
        return new SingleStockTabularView(singleStockTabularViewModel, singleStockControllers, menuController);
    }
}
