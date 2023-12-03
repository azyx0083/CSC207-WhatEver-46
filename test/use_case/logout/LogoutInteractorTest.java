package use_case.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.menu.MenuViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutInteractorTest {
    static ViewManagerModel viewManagerModel;
    static MenuViewModel menuViewModel;
    static LogoutPresenter presenter;
    @BeforeAll
    static void setUp(){
        menuViewModel = new MenuViewModel();
        viewManagerModel = new ViewManagerModel();
        menuViewModel.getState().setUsername("test");
        presenter = new LogoutPresenter(menuViewModel,viewManagerModel);
    }

    @Test
    void testLogout(){
        LogoutInteractor interactor = new LogoutInteractor(presenter);
        interactor.execute();
        assertNull(menuViewModel.getState().getUsername());
    }
}
