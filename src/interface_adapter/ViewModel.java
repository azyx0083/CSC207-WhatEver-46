package interface_adapter;

import java.awt.*;
import java.beans.PropertyChangeListener;

public abstract class ViewModel {
    private String viewName;
    public final static Font font1 = new Font("Serif", Font.BOLD, 18);
    public final static Font font2 = new Font("Serif", Font.BOLD, 20);
    public final static Font font3 = new Font("SansSerif", Font.PLAIN, 14);

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return this.viewName;
    }

    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
