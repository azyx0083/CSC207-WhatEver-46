package app;


import data_access.APIDataAccess;
import data_access.FileUserDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.search.SearchViewModel;
import interface_adapter.settings.SettingsViewModel;
import interface_adapter.single_stock.SingleStockViewModel;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import  view.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JFrame application = new JFrame("Single Stock Visualization");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        APIDataAccess apiDataAccess = new APIDataAccess();
        FileUserDataAccess fileUserDataAccess = new FileUserDataAccess("file.txt");

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        MenuViewModel menuViewModel = new MenuViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        SettingsViewModel settingsViewModel = new SettingsViewModel();

        SingleStockTabularViewModel singleStockTabularViewModel = new SingleStockTabularViewModel();
        SingleStockGraphicalViewModel singleStockGraphicalViewModel = new SingleStockGraphicalViewModel();

        Map<String, SingleStockViewModel> singleStockViewModels = new HashMap<>();
        singleStockViewModels.put("Table", singleStockTabularViewModel);
        singleStockViewModels.put("Graph", singleStockGraphicalViewModel);

        OptionsView optionsView = OptionsUseCaseFactory.create(searchViewModel,viewManagerModel,
                singleStockViewModels, apiDataAccess,fileUserDataAccess);
        views.add(optionsView, optionsView.viewName);

        MenuView menuView = MenuUseCaseFactory.create(viewManagerModel, menuViewModel, searchViewModel, apiDataAccess,
                fileUserDataAccess, settingsViewModel, fileUserDataAccess);
        views.add(menuView, menuView.viewName);

        SettingsView settingsView = SettingsUseCaseFactory.create(viewManagerModel, settingsViewModel, menuViewModel,
                fileUserDataAccess);
        views.add(settingsView, settingsView.viewName);

        SingleStockTabularView singleStockTabularView = SingleStockTabularUseCaseFactory.createTabular(viewManagerModel,
                menuViewModel, singleStockViewModels, apiDataAccess);
        views.add(singleStockTabularView,singleStockTabularView.viewName);

        SingleStockGraphicalView singleStockGraphicalView = SingleStockGraphicalUseCaseFactory.createGraphical(viewManagerModel,
                menuViewModel, singleStockViewModels, apiDataAccess);
        views.add(singleStockGraphicalView,singleStockGraphicalView.viewName);

        viewManagerModel.setActiveView(menuView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
