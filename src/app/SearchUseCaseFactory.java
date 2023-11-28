package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import view.OptionsView;

import java.util.Map;

public class SearchUseCaseFactory {
    public static OptionsView create(SearchViewModel searchViewModel,
                                     ViewManagerModel viewManagerModel,
                                     SingleStockTabularViewModel singleStockTabularViewModel,
                                     SingleStockGraphicalViewModel singleStockGraphicalViewModel,
                                     APIDataAccess dataAccess){
        Map<String, SingleStockController> map = SingleStockUseCaseFactory.createSingleStockUsecase(viewManagerModel,
                singleStockTabularViewModel,singleStockGraphicalViewModel,new APIDataAccess());
        return new OptionsView(searchViewModel,map);
    }

}
