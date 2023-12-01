package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockViewModel;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import view.OptionsView;

import java.util.Map;

public class OptionsUseCaseFactory {
    public static OptionsView create(SearchViewModel searchViewModel,
                                     ViewManagerModel viewManagerModel,
                                     Map<String, SingleStockViewModel> singleStockViewModels,
                                     APIDataAccess dataAccess){
        Map<String, SingleStockController> map = SingleStockUseCaseFactory.createSingleStockUsecase(viewManagerModel,
                singleStockViewModels,dataAccess);
        return new OptionsView(searchViewModel,map);
    }

    public static SearchController createSearchUseCase(ViewManagerModel viewManagerModel,
                                                       SearchViewModel searchViewModel,
                                                       APIDataAccess apiDataAccess){
        SearchOutputBoundary searchPresenter = new SearchPresenter(searchViewModel,viewManagerModel);
        SearchInputBoundary searchInteractor = new SearchInteractor(searchPresenter,apiDataAccess);
        return new SearchController(searchInteractor);
    }

}
