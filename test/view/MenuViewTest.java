package view;

import app.factory.MenuUseCaseFactory;
import data_access.APIDataAccess;
import data_access.FileUserDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.settings.SettingsViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.*;

public class MenuViewTest {
    static ViewManagerModel viewManagerModel;
    static MenuViewModel menuViewModel;
    static SearchViewModel searchViewModel;
    static APIDataAccess apiDataAccess;
    static FileUserDataAccess fileUserDataAccess;
    static SettingsViewModel settingsViewModel;
    static SignupViewModel signupViewModel;
    static LoginViewModel loginViewModel;
    static MenuView menuView;
    @BeforeAll
    static void setUp() {
        viewManagerModel = new ViewManagerModel();
        menuViewModel = new MenuViewModel();
        searchViewModel = new SearchViewModel();
        apiDataAccess = new APIDataAccess();
        fileUserDataAccess = new FileUserDataAccess("file.txt");
        fileUserDataAccess.clear();
        settingsViewModel = new SettingsViewModel();
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        menuView = MenuUseCaseFactory.create(viewManagerModel, menuViewModel, searchViewModel, apiDataAccess,
                fileUserDataAccess, settingsViewModel, fileUserDataAccess, signupViewModel, loginViewModel);

        // Create the UI
        JFrame jf = new JFrame();
        jf.setContentPane(menuView);
        jf.pack();
        jf.setVisible(true);
    }

    // Checks that the menu view is set up with buttons
    @Test
    public void testSetUp() {
        // Checks that the buttons aren't null
        assertNotNull(menuView);
        assertNotNull(menuView.signup);
        assertNotNull(menuView.login);
    }

    // Checks if the state is properly changed
    @Test
    public void testPropertyChange_UserLoggedIn() {
        // Set up the sample user for login
        String sampleUsername = "sample";
        menuViewModel.getState().setUsername(sampleUsername);

        // Start a PropertyChangeEvent
        menuView.propertyChange(new PropertyChangeEvent(this, "username",
                null, menuViewModel.getState()));

        // Check is the user is there, and shows up correctly
        assertTrue(menuView.user.isVisible());
        assertEquals("Signed in as: " + sampleUsername, menuView.user.getText());
    }

}
