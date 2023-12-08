package view;

import app.factory.OptionsUseCaseFactory;
import data_access.APIDataAccess;
import data_access.FileUserDataAccess;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.single_stock.SingleStockViewModel;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OptionsViewTest {
    static SearchViewModel searchViewModel;
    static ViewManagerModel viewManagerModel;
    static APIDataAccess apiDataAccess;
    static FileUserDataAccess fileUserDataAccess;
    static Map<String, SingleStockViewModel> singleStockViewModels;
    static OptionsView optionsView;
    @BeforeAll
    static void setUp() {
       searchViewModel = new SearchViewModel();
       viewManagerModel = new ViewManagerModel();

       // Set up the single stock view models
       SingleStockTabularViewModel singleStockTabularViewModel = new SingleStockTabularViewModel();
       SingleStockGraphicalViewModel singleStockGraphicalViewModel = new SingleStockGraphicalViewModel();
       singleStockViewModels = new HashMap<>();
       singleStockViewModels.put("Table", singleStockTabularViewModel);
       singleStockViewModels.put("Graph", singleStockGraphicalViewModel);

       apiDataAccess = new APIDataAccess();
       fileUserDataAccess = new FileUserDataAccess("file.txt");
       fileUserDataAccess.clear();

       optionsView = OptionsUseCaseFactory.create(searchViewModel,viewManagerModel,
               singleStockViewModels, apiDataAccess,fileUserDataAccess);

        // Create the UI
        JFrame jf = new JFrame();
        jf.setContentPane(optionsView);
        jf.pack();
        jf.setVisible(true);
    }

    // Checks that the options view is set up with buttons
    @Test
    public void testSetUp() {
        // Checks that the view isn't null
        assertNotNull(optionsView);
    }

    // Given that the user searched a stock, check if the optionView get updated
    @Test
    void propertyChange_UpdatesLabelsOnStateChange() {
        // Start with an example: "The user want to search the stock with symbol "AAPL"
        String sampleStockSymbol = "AAPL";
        String sampleStockName = "Apple Inc.";
        SearchState searchState = new SearchState();
        searchState.setSymbol(sampleStockSymbol);
        searchState.setName(sampleStockName);

        // Start a PropertyChangeEvent
        optionsView.propertyChange(new PropertyChangeEvent(searchViewModel,
                "state", null, searchState));

        // Check if the symbol and name of the stock changes
        assertEquals(sampleStockSymbol, optionsView.stockSymbol.getText());
        assertEquals(sampleStockName, optionsView.stockName.getText());
    }
}
