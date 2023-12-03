package interface_adapter;

import java.awt.*;
import java.beans.PropertyChangeListener;

public abstract class ViewModel {
    private String viewName;
    public final static Font font1 = new Font("Serif", Font.BOLD, 18);
    public final static Font font2 = new Font("Serif", Font.BOLD, 20);
    public final static Font font3 = new Font("SansSerif", Font.PLAIN, 14);

    /**
     * Constructs a view model.
     * @param viewName the name which specifies the type of that view.
     */
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    /**
     * Given that there is a view model, get the type of this view model.
     * @return the name which specifies the type of that view.
     */
    public String getViewName() {
        return this.viewName;
    }

    /**
     * Called by presenters to alert the view; must be implemented by all subclasses.
     */
    public abstract void firePropertyChanged();

    /**
     * Add a listener which detects changes; must be implemented by all subclasses.
     * @param listener a PropertyChangeListener.
     */
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
