package interface_adapter.search;

import interface_adapter.ViewModel;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {
    public static String[] LABEL = new String[]{"Graph", "Table"};
    private SearchState state = new SearchState();
    public SearchViewModel() {
        super("Search");
    } // "Search" is the view name.

    /**
     * Assigns a SearchState to the view model.
     * @param state the state used by the search use case.
     */
    public void setState(SearchState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Search Presenter will call to let the ViewModel know
    // to alert the View

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Given a SearchViewModel, get the SearchState.
     * @return the SearchState object.
     */
    public SearchState getState() {
        return state;
    }

}
