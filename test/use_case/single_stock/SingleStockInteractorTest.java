package use_case.single_stock;

import data_access.APIDataAccess;
import entity.Stock;
import entity.UserSetting;
import interface_adapter.ViewManagerModel;
import interface_adapter.single_stock.SingleStockPresenter;
import interface_adapter.single_stock.SingleStockViewModel;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class SingleStockInteractorTest {
    static APIDataAccess apiDataAccess = new APIDataAccess();
    static SingleStockPresenter tabularPresenter;
    static SingleStockPresenter graphicalPresenter;
    static SingleStockTabularViewModel tabularViewModel;
    static SingleStockGraphicalViewModel graphicalViewModel;
    static String[] validSymbol = new String[]{"AMZN", "AAPL"};

    @BeforeAll
    static void setUp() {
        apiDataAccess = new APIDataAccess();
        for (String symbol : validSymbol) {
            apiDataAccess.search(symbol, new UserSetting("1day", 30));
            assert apiDataAccess.getSearchHistories().containsKey(symbol);
        }
        tabularViewModel = new SingleStockTabularViewModel();
        tabularPresenter = new SingleStockPresenter(tabularViewModel, new ViewManagerModel());
        graphicalViewModel = new SingleStockGraphicalViewModel();
        graphicalPresenter = new SingleStockPresenter(graphicalViewModel, new ViewManagerModel());
    }

    static void testUpdate(SingleStockPresenter presenter, SingleStockViewModel viewModel) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        SingleStockInteractor interactor = new SingleStockInteractor(presenter, apiDataAccess);
        interactor.execute(new SingleStockInputData(validSymbol[randomNum]));
        Stock stock = apiDataAccess.getSearchHistories().get(validSymbol[randomNum]);
        String title = String.format("%s-%s", stock.getSymbol(), stock.getName());
        String detail = String.format("%s | %s | %s", stock.getExchange(), stock.getCountry(), stock.getType());
        String currentPrice = String.format("%s %s", stock.getCurrentPrice(), stock.getCurrency());
        assertEquals(validSymbol[randomNum], viewModel.getState().getSymbol());
        assertEquals(title, viewModel.getState().getTitle());
        assertEquals(detail, viewModel.getState().getDetail());
        assertEquals(currentPrice, viewModel.getState().getCurrentPrice());
        assertEquals(stock.getHistoricalPrice(), viewModel.getState().getData().getData());
    }

    @Test
    void testTabularUpdate() {
        testUpdate(tabularPresenter, tabularViewModel);
    }

    @Test
    void testGraphicalUpdate() {
        testUpdate(graphicalPresenter, graphicalViewModel);
    }
}