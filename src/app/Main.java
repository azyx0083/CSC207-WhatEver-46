package app;


import interface_adapter.ViewManagerModel;
import interface_adapter.menu.*;
import use_case.menu.*;
import view.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Single Stock Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        MenuViewModel menuViewModel = new MenuViewModel();

        SingleStockGraphicalView graphicalView = new SingleStockGraphicalView();
        SingleStockTabularView tabularView = new SingleStockTabularView();
        MenuView menuView = MenuUseCaseFactory.create(viewManagerModel, menuViewModel);

        views.add(graphicalView, graphicalView.viewName);
        views.add(tabularView,tabularView.viewName);
        views.add(menuView, menuView.viewName);

        application.pack();
        application.setVisible(true);

    }
}
