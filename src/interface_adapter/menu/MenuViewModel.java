package interface_adapter.menu;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MenuViewModel extends ViewModel {
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String TITLE_LABEL = "Search Menu";
    public static final String SEARCH_LABEL = "Stock Symbol";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private MenuState state = new MenuState();

    public MenuViewModel() {
        super("menu");
    }

    /**
     * Assigns a MenuState to the view model.
     * @param state A MenuState object to be associated with the current view
     */
    public void setState(MenuState state) {
        this.state = state;
    }

    /**
     * Returns the MenuState associated with the view model.
     * @return MenuState object stored
     */
    public MenuState getState() {
        return state;
    }

    /**
     * Gets the view name.
     * @return the view name
     */
    public String getViewName() {
        return "menu";
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
