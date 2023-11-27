package app;

import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import view.SearchView;
import view.SingleStockTabularView;

public class SearchUseCaseFactory {
    public static SearchView create(SearchViewModel searchViewModel,
                                    ViewManagerModel viewManagerModel,
                                    SingleStockTabularViewModel singleStockTabularViewModel,
                                    SingleStockGraphicalViewModel singleStockGraphicalViewModel,
                                    APIDataAccess dataAccess){
        SearchController searchController = createSearchUseCase(viewManagerModel,searchViewModel,dataAccess);
        SingleStockController singleStockGraphicalController = SingleStockUseCaseFactory.createSingleStockGraphicalUseCase(
                viewManagerModel,singleStockGraphicalViewModel,dataAccess
        );
        //SingleStockUseCaseFactory[] Array = new SingleStockUseCaseFactory[]{new SingleStockGraphicalFactory(),
        //new SingleStockTabularFactory()};

        SingleStockController singleStockTabularController = SingleStockUseCaseFactory.createSingleStockTabularUseCase(
                viewManagerModel,singleStockTabularViewModel,dataAccess
        );
        return new SearchView(searchViewModel, searchController, singleStockGraphicalController, singleStockTabularController);
    }
    public static SearchController createSearchUseCase(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel,
                                      APIDataAccess dataAccessObject){
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter(searchViewModel,viewManagerModel);
        SearchInputBoundary searchInputBoundary = new SearchInteractor(searchOutputBoundary,dataAccessObject);
        return new SearchController(searchInputBoundary);
    }
}
