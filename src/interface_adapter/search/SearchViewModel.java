package interface_adapter.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {
    public static String TABLE_BUTTON_LABEL = "Table";

    public static String GRAPH_BUTTON_LABEL = "Graph";

    private SearchState state = new SearchState();

    public SearchViewModel() {
        super("Search");
    }

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

}
