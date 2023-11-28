package interface_adapter.search;

import interface_adapter.ViewModel;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class SearchViewModel extends ViewModel {
    public static String[] LABEL = new String[]{"Graph", "Table"};
    private SearchState state = new SearchState();
    public SearchViewModel() {
        super("Search");
    } // "Search" is the view name.
    public void setState(SearchState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public static final Font font1 = new Font("Serif", Font.BOLD, 18); // The two fonts to display.
    public static final Font font2 = new Font("Serif", Font.PLAIN, 18);

    // This is what the Search Presenter will call to let the ViewModel know
    // to alert the View

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SearchState getState() {
        return state;
    }

}
