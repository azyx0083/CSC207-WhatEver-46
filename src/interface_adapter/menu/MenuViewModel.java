package interface_adapter.menu;

public class MenuViewModel {
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String TITLE_LABEL = "Search Menu";
    public static final String SEARCH_LABEL = "NASDAQ Stock Symbol";

    private MenuState state = new MenuState();

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
}
