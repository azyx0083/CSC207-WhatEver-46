package interface_adapter.settings;

import interface_adapter.ViewModel;
import interface_adapter.menu.MenuState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SettingsViewModel extends ViewModel {
    public static final String INTERVAL_LABEL = "interval?";
    public static final String DATA_SIZE_LABEL = "datasize?";
    public static final String FAVORITE_STOCKS_LABEL = "fav?";
    public static final String APPLY_BUTTON_LABEL = "Apply";
    public static final String TO_MENU_BUTTON_LABEL = "Menu";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private SettingsState state = new SettingsState();

    public SettingsViewModel() {
        super("settings");
    }

    /**
     * Assigns a SettingsState to the view model.
     * @param state A SettingsState object to be associated with the current view
     */
    public void setState(SettingsState state) {
        this.state = state;
    }

    /**
     * Returns the SettingsState associated with the view model.
     * @return SettingsState object stored
     */
    public SettingsState getState() {
        return state;
    }

    /**
     * Gets the view name.
     * @return the view name
     */
    public String getViewName() {
        return "settings";
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
