package interface_adapter.menu;

import use_case.*;
import use_case.menu.*;

public class MenuController{
    final MenuInputBoundary menuInputBoundary;

    public MenuController(MenuInputBoundary menuInputBoundary) {
        this.menuInputBoundary = menuInputBoundary;
    }
    public void executeStockSearch(String stockSymbol) {
        //SearchInputData searchInputData = new SearchInputData(stockSymbol); TODO uncomment once implemented

    }

}
