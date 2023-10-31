package app;


import data_access.APIDataAccess;
import entity.Stock;
import interface_adapter.ViewManagerModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockTabularViewModel;
import interface_adapter.single_stock.SingleStockViewModel;
import use_case.single_stock.SingleStockAPIDataAccessInterface;
import  view.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Single Stock Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        APIDataAccess apiDataAccess = new APIDataAccess();

        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Initialize the table view, will replace this part with the input field in Menu
        String symbol = "AMZN";
        String name = apiDataAccess.validSymbol(symbol);
        Stock stock = apiDataAccess.getStockData(name, symbol);

        JPanel views = new JPanel(cardLayout);
        application.add(views);
        SingleStockTabularViewModel singleStockTabularViewModel = new SingleStockTabularViewModel(name, symbol,
                stock.getHistoricalPrices(), stock.getHistoricalDates());

        SingleStockGraphicalView graphicalView = new SingleStockGraphicalView();

        SingleStockTabularView singleStockTabularView = SingleStockUseCaseFactory.createTabular(viewManagerModel,
                singleStockTabularViewModel, apiDataAccess);

        MenuView menuView = new MenuView();
//        views.add(graphicalView, graphicalView.viewName);
        views.add(singleStockTabularView,singleStockTabularView.viewName);
//        views.add(menuView, menuView.viewName);
        application.pack();
        application.setVisible(true);
    }
}
