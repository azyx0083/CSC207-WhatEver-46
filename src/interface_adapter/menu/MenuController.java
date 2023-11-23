package interface_adapter.menu;

import use_case.menu.*;

public class MenuController{
    final MenuInputBoundary menuInputBoundary;

    /**
     * Constructor; just assigns an MenuInputBoundary.
     * @param menuInputBoundary
     */
    public MenuController(MenuInputBoundary menuInputBoundary) {
        this.menuInputBoundary = menuInputBoundary;
    }

    /**
     * Returns to the menu.
     */
    public void returnToMenu() {
        menuInputBoundary.prepareMenuView();
    }

}
