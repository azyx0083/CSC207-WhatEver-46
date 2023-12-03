package use_case.search;

import data_access.APIDataAccess;
import data_access.FileUserDataAccess;
import data_access.InMemoryUserDataAccess;
import entity.Stock;
import entity.User;
import entity.UserFactory;
import entity.UserSetting;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class SearchInteractorTest {
    static APIDataAccess apiDataAccess = new APIDataAccess();
    static String validSymbol = "AMZN";
    static String invalidSymbol = "112";
    static SearchPresenter presenter;
    static SearchViewModel searchViewModel;
    static InMemoryUserDataAccess fileUserDataAccess;
    static MenuViewModel menuViewModel;
    static User sampleUser;

    @BeforeAll
    static void setUp(){
        apiDataAccess = new APIDataAccess();
        searchViewModel = new SearchViewModel();
        menuViewModel = new MenuViewModel();
        presenter = new SearchPresenter(searchViewModel,menuViewModel, new ViewManagerModel());
        fileUserDataAccess = new InMemoryUserDataAccess();
        sampleUser = UserFactory.createUser("sample", "111", "1day", 10);
        fileUserDataAccess.save(sampleUser);
    }

    @Test
    void testSuccessViewWithUser(){
        SearchInteractor interactor = new SearchInteractor(presenter,apiDataAccess,fileUserDataAccess);
        interactor.execute(new SearchInputData(validSymbol, "sample"));
        Stock stock = apiDataAccess.getStock(validSymbol);
        assertEquals(stock.getSymbol(), searchViewModel.getState().getSymbol());
        assertEquals(stock.getName(), searchViewModel.getState().getName());
    }

    @Test
    void testFailViewWithUser(){
        SearchInteractor interactor = new SearchInteractor(presenter,apiDataAccess, fileUserDataAccess);
        interactor.execute(new SearchInputData(invalidSymbol, "sample"));
        assertEquals(apiDataAccess.search(invalidSymbol, new UserSetting("1day", 30)), searchViewModel.getState().getSymbolError());
    }

    @Test
    void testSuccessViewWithoutUser(){
        SearchInteractor interactor = new SearchInteractor(presenter, apiDataAccess, fileUserDataAccess);
        interactor.execute(new SearchInputData(validSymbol, null));
        Stock stock = apiDataAccess.getStock(validSymbol);
        assertEquals(stock.getSymbol(), searchViewModel.getState().getSymbol());
        assertEquals(stock.getName(), searchViewModel.getState().getName());
    }

    @Test
    void testFailViewWithoutUser(){
        SearchInteractor interactor = new SearchInteractor(presenter,apiDataAccess, fileUserDataAccess);
        interactor.execute(new SearchInputData(invalidSymbol, null));
        assertEquals(apiDataAccess.search(invalidSymbol, new UserSetting("1day", 30)), searchViewModel.getState().getSymbolError());
    }
}
