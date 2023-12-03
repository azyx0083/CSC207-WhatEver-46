package use_case.search;

import data_access.APIDataAccess;
import entity.Stock;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchInteractorTest {
    static APIDataAccess apiDataAccess = new APIDataAccess();
    static String validSymbol = "AMZN";
    static String invalidSymbol = "112";
    static SearchPresenter presenter;
    static SearchViewModel searchViewModel;

    @BeforeAll
    static void setUp(){
        apiDataAccess = new APIDataAccess();
        searchViewModel = new SearchViewModel();
        presenter = new SearchPresenter(searchViewModel, new MenuViewModel(), new ViewManagerModel());
    }

    @Test
    void testSuccessView(){
        SearchInteractor interactor = new SearchInteractor(presenter,apiDataAccess);
        interactor.execute(new SearchInputData(validSymbol));
        Stock stock = apiDataAccess.getStock(validSymbol);
        assertEquals(stock.getSymbol(), searchViewModel.getState().getSymbol());
        assertEquals(stock.getName(), searchViewModel.getState().getName());
    }

    @Test
    void testFailView(){
        SearchInteractor interactor = new SearchInteractor(presenter,apiDataAccess);
        interactor.execute(new SearchInputData(invalidSymbol));
        assertEquals(apiDataAccess.search(invalidSymbol), searchViewModel.getState().getSymbolError());
    }
}
