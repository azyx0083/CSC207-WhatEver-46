package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.OptionsViewModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockViewModel;
import view.OptionsView;

import java.util.Map;

public class OptionsUseCaseFactory {
    public static OptionsView create(OptionsViewModel optionsViewModel,
                                     ViewManagerModel viewManagerModel,
                                     Map<String, SingleStockViewModel> singleStockViewModels,
                                     APIDataAccess dataAccess){
        Map<String, SingleStockController> map = SingleStockUseCaseFactory.createSingleStockUsecase(viewManagerModel,
                singleStockViewModels,dataAccess);
        return new OptionsView(optionsViewModel,map);
    }



}
