package data_access;

import entity.DefaultSetting;
import entity.Stock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for APIDataAccessObject
 * The api has a per minute limited usage
 * This tests covers all the cases including the ones when user reach the per minute limit
 * Only run this test once every minute (otherwise no tests would pass)
 */
class APIDataAccessTest {
    static String emptySymbol = "";
    static String validSymbol = "AMZN";
    static String validSymbol2 = "AAPL";
    static String invalidSymbol = "aakkk";
    static DefaultSetting defaultSetting = new DefaultSetting();
    static APIDataAccess apiDataAccess = new APIDataAccess();

    @Test
    void testValid() {
        assert !apiDataAccess.getSearchHistories().containsKey(validSymbol);
        assertNull(apiDataAccess.search(validSymbol));
        assertNotNull(apiDataAccess.getName(validSymbol));
        Stock stock = apiDataAccess.getStock(validSymbol);
        assertNotNull(stock.getName());
        assertNotNull(stock.getSymbol());
        assertNotNull(stock.getExchange());
        assertNotNull(stock.getCurrency());
        assertNotNull(stock.getType());
        assertNotNull(stock.getCountry());
        for (Object[] value : stock.getHistoricalPrice().values()) {
            assert value.length == defaultSetting.getOutputSize();
        }
        assert apiDataAccess.getSearchHistories().containsKey(stock.getSymbol());
        assertNotNull(apiDataAccess.getStock(validSymbol));
        assertEquals(stock.getName(), apiDataAccess.getName(validSymbol));

    }

    @Test
    void testInvalid() {
        assertEquals(apiDataAccess.search(invalidSymbol),
                String.format("%s is not a valid symbol. Please enter a correct stock symbol.", invalidSymbol));
        assertNull(apiDataAccess.getStock(invalidSymbol));
    }

    @Test
    void testEmpty() {
        assertEquals(apiDataAccess.search(emptySymbol),
                String.format("%s is not a valid symbol. Please enter a correct stock symbol.", emptySymbol));
        assertNull(apiDataAccess.getStock(emptySymbol));
    }

    @Test
    void testSearchHistory() {
        assert apiDataAccess.getSearchHistories().containsKey(validSymbol);
        assertNull(apiDataAccess.search(validSymbol));
    }

    @AfterAll
    static void testFrequentRequest() {
        assertEquals(apiDataAccess.search(validSymbol2),
                "Frequent request. Please try again in one minute.");
    }
}