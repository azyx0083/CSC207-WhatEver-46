package interface_adapter.search;

import interface_adapter.ViewModel;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OptionsViewModel extends ViewModel {
    public static String[] LABEL = new String[]{"Graph", "Table"};
    private OptionsState state = new OptionsState();
    public OptionsViewModel() {
        super("Search");
    } // "Search" is the view name.
    public void setState(OptionsState state) {
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

    public OptionsState getState() {
        return state;
    }

}
