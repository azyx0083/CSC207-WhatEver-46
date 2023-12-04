package use_case.settings;

import data_access.FileUserDataAccess;
import entity.User;
import entity.UserSetting;
import interface_adapter.ViewManagerModel;
import interface_adapter.settings.SettingsPresenter;
import interface_adapter.settings.SettingsViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SettingsInteractorTest {
    static SettingsPresenter presenter;
    static SettingsViewModel viewModel;
    static SettingsInteractor interactor;
    static ViewManagerModel manager;
    static FileUserDataAccess userAccess;

    @BeforeAll
    static void setup() {
        viewModel = new SettingsViewModel();
        manager = new ViewManagerModel();
        userAccess = new FileUserDataAccess("file.txt");
        presenter = new SettingsPresenter(manager, viewModel);
        interactor = new SettingsInteractor(presenter, userAccess);
        UserSetting setting = new UserSetting("1week", 2);
        User user = new User("John", "123", setting);
        userAccess.save(user);
    }

    @Test
    void testApplyChanges() {
        SettingsInputData inputData = new SettingsInputData("1day", 3, "John");
        interactor.applyChanges(inputData);
        UserSetting setting = userAccess.get("John").getSetting();
        assertEquals(setting.getInterval(), "1day");
        assertEquals(setting.getOutputSize(), 3);
    }

    @Test
    void testGoToSettings() {
        interactor.goToSettings("John");
        assertEquals(manager.getActiveView(), viewModel.getViewName());
        assertEquals(viewModel.getState().getUsername(), "John");
    }
}
