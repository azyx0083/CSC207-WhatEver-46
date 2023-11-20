package data_access;

import entity.DefaultUser;
import entity.Stock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class APIDataAccessTest {
    static String emptySymbol = "";
    static String validSymbol = "AMZN";
    static String validSymbol2 = "AAPL";
    static String invalidSymbol = "aakkk";
    static APIDataAccess apiDataAccess;

    @BeforeAll
    static void testInitializer() {
        apiDataAccess = new APIDataAccess();
        assertEquals(apiDataAccess.getCurrentUser().getClass(), DefaultUser.class);
    }

    @Test
    void testValid() {
        assert !apiDataAccess.getCurrentUser().getSearchHistories().containsKey(validSymbol);
        assertNull(apiDataAccess.search(validSymbol));
        assertNotNull(apiDataAccess.getName(validSymbol));
        Stock stock = apiDataAccess.getStock(validSymbol);
        assertNotNull(stock.getName());
        assertNotNull(stock.getSymbol());
        assertNotNull(stock.getCountry());
        assertNotNull(stock.getCurrency());
        assertNotNull(stock.getExchange());
        assertNotNull(stock.getType());
        for (Object[] value : stock.getHistoricalPrices().values()) {
            assert value.length == 30;
        }
        assert apiDataAccess.getCurrentUser().getSearchHistories().containsKey(stock.getSymbol());
        assertEquals(stock.getName(), apiDataAccess.getName(validSymbol));

    }

    @Test
    void testInvalid() {
        assertEquals(apiDataAccess.search(invalidSymbol),
                String.format("%s is not a valid symbol. Please enter a correct stock symbol.", invalidSymbol));
        assertNull(apiDataAccess.getStock(invalidSymbol));
        assertNull(apiDataAccess.getName(invalidSymbol));
    }

    @Test
    void testEmpty() {
        assertEquals(apiDataAccess.search(emptySymbol),
                String.format("%s is not a valid symbol. Please enter a correct stock symbol.", emptySymbol));
        assertNull(apiDataAccess.getStock(emptySymbol));
        assertNull(apiDataAccess.getName(emptySymbol));
    }

    @Test
    void testSearcHistory() {
        assert apiDataAccess.getCurrentUser().getSearchHistories().containsKey(validSymbol);
        assertNull(apiDataAccess.search(validSymbol));
    }

    @AfterAll
    static void testFrequentRequest() {
        assertEquals(apiDataAccess.search(validSymbol2),
                "Frequent request. Please try again later.");
    }
}