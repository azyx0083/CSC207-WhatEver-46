package interface_adapter.menu;

public class MenuViewModel {
    public static final String SEARCH_BUTTON_LABEL = "Search";
    public static final String TITLE_LABEL = "Search Menu";
    public static final String SEARCH_LABEL = "NASDAQ Stock Symbol";

    private MenuState state = new MenuState();

    public void setState(MenuState state) {
        this.state = state;
    }

    public MenuState getState() {
        return state;
    }
}
