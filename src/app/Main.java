package app;


import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
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

        APIDataAccess apiDataAccess = new APIDataAccess();

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        MenuViewModel menuViewModel = new MenuViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        SingleStockTabularViewModel singleStockTabularViewModel = new SingleStockTabularViewModel();
        SingleStockGraphicalViewModel singleStockGraphicalViewModel = new SingleStockGraphicalViewModel();

        SearchView searchView = SearchUseCaseFactory.create(searchViewModel,viewManagerModel,
                singleStockTabularViewModel, singleStockGraphicalViewModel, apiDataAccess);
        views.add(searchView, searchView.viewName);

        MenuView menuView = MenuUseCaseFactory.create(viewManagerModel, menuViewModel, searchViewModel, apiDataAccess);
        views.add(menuView, menuView.viewName);

        SingleStockTabularView singleStockTabularView = SingleStockTabularUseCaseFactory.createTabular(viewManagerModel,
                menuViewModel, singleStockTabularViewModel, singleStockGraphicalViewModel, apiDataAccess);
        views.add(singleStockTabularView,singleStockTabularView.viewName);

        SingleStockGraphicalView singleStockGraphicalView = SingleStockGraphicalUseCaseFactory.createGraphical(viewManagerModel,
                menuViewModel, singleStockTabularViewModel, singleStockGraphicalViewModel, apiDataAccess);
        views.add(singleStockGraphicalView,singleStockGraphicalView.viewName);

        viewManagerModel.setActiveView(menuView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
