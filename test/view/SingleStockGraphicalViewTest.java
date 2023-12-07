package view;

import app.factory.SingleStockGraphicalUseCaseFactory;
import data_access.APIDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.single_stock.SingleStockViewModel;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SingleStockGraphicalViewTest {
    static ViewManagerModel viewManagerModel;
    static MenuViewModel menuViewModel;
    static Map<String, SingleStockViewModel> singleStockViewModels;
    static APIDataAccess apiDataAccess;
    static SingleStockGraphicalView singleStockGraphicalView;

    @BeforeAll
    static void setUp() {
        viewManagerModel = new ViewManagerModel();
        menuViewModel = new MenuViewModel();
        SingleStockTabularViewModel singleStockTabularViewModel = new SingleStockTabularViewModel();
        SingleStockGraphicalViewModel singleStockGraphicalViewModel = new SingleStockGraphicalViewModel();
        singleStockViewModels = new HashMap<>();
        singleStockViewModels.put("Table", singleStockTabularViewModel);
        singleStockViewModels.put("Graph", singleStockGraphicalViewModel);
        apiDataAccess = new APIDataAccess();
        singleStockGraphicalView = SingleStockGraphicalUseCaseFactory.createGraphical(viewManagerModel,
                menuViewModel, singleStockViewModels, apiDataAccess);

        // Create the UI
        JFrame jf = new JFrame();
        jf.setContentPane(singleStockGraphicalView);
        jf.pack();
        jf.setVisible(true);
    }

    // Checks that the graphical view is set up with buttons
    @Test
    public void testSetUp() {
        // Checks that the buttons aren't null
        assertNotNull(singleStockGraphicalView);
        assertNotNull(singleStockGraphicalView.viewName);
        assertNotNull(singleStockGraphicalView.chart);
        assertNotNull(singleStockGraphicalView.currentPrice);
        assertNotNull(singleStockGraphicalView.detail);
        assertNotNull(singleStockGraphicalView.title);
        assertNotNull(singleStockGraphicalView.menu);
    }

    @Test
    public void testCancelButtonPerformed() {

        singleStockGraphicalView.menu.doClick(); // Click the Button

        // Check(Ensure) that after clicking the button, the menuState has an empty stock symbol.
        MenuState menuState = menuViewModel.getState();
        assertEquals("", menuState.getStockSymbol());
    }
}
