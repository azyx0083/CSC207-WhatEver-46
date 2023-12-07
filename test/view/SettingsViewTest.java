package view;

import app.factory.SettingsUseCaseFactory;
import data_access.FileUserDataAccess;
import entity.User;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.settings.SettingsViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SettingsViewTest {
    static ViewManagerModel viewManagerModel;
    static SettingsViewModel settingsViewModel;
    static MenuViewModel menuViewModel;
    static FileUserDataAccess fileUserDataAccess;
    static User sampleUser;
    static SettingsView settingsView;

    @BeforeAll
    static void setUp() {
        viewManagerModel = new ViewManagerModel();
        settingsViewModel = new SettingsViewModel();
        menuViewModel = new MenuViewModel();
        fileUserDataAccess = new FileUserDataAccess("file.txt");
        fileUserDataAccess.clear();
        sampleUser = UserFactory.createUser("sample", "password", "1day", 10);
        fileUserDataAccess.save(sampleUser);
        settingsView = SettingsUseCaseFactory.create(viewManagerModel, settingsViewModel, menuViewModel, fileUserDataAccess);

        // Create the UI
        JFrame jf = new JFrame();
        jf.setContentPane(settingsView);
        jf.pack();
        jf.setVisible(true);
    }

    // Checks that the settings view is set up with buttons
    @Test
    public void testSetUp() {
        // Checks that the buttons aren't null
        assertNotNull(settingsView);
        assertNotNull(settingsView.apply);
        assertNotNull(settingsView.returnToMenu);
    }

    @Test
    public void testSettingsButtonsPerformed() {
        settingsView.returnToMenu.doClick(); // Click the button

        // Check(Ensure) that after clicking the button, the menuState has an empty stock symbol.
        MenuState menuState = menuViewModel.getState();
        assertEquals("", menuState.getStockSymbol());

    }

}
