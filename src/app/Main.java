package app;


import use_case.menu.MenuInputData;
import  view.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Single Stock Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        MenuInputData menuInputData = new MenuInputData();

        SingleStockGraphicalView graphicalView = new SingleStockGraphicalView();
        SingleStockTabularView tabularView = new SingleStockTabularView();
        MenuView menuView = new MenuView();

        views.add(graphicalView, graphicalView.viewName);
        views.add(tabularView,tabularView.viewName);
        views.add(menuView, menuView.viewName);
        application.pack();
        application.setVisible(true);

    }
}
