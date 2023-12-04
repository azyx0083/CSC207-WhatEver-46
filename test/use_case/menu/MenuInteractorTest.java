package use_case.menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.menu.MenuViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuInteractorTest {
    static MenuPresenter presenter;
    static MenuViewModel viewModel;
    static MenuInteractor interactor;
    static ViewManagerModel manager;

    @BeforeAll
    static void setup() {
        viewModel = new MenuViewModel();
        manager = new ViewManagerModel();
        presenter = new MenuPresenter(manager, viewModel);
        interactor = new MenuInteractor(presenter);
    }

    @Test
    void testSwitchToMenu() {
        interactor.prepareMenuView();
        assertEquals(manager.getActiveView(), viewModel.getViewName());
    }

    @Test
    void testSwitchToMenuWithUsername() {
        interactor.prepareMenuView("John");
        assertEquals(manager.getActiveView(), viewModel.getViewName());
        assertEquals(viewModel.getState().getUsername(), "John");
    }
}
