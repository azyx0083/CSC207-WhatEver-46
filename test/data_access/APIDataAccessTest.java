package data_access;

import entity.Stock;
import entity.UserSetting;
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
    static UserSetting defaultSetting = new UserSetting("1day", 30);
    static APIDataAccess apiDataAccess = new APIDataAccess();

    /**
     * Search a valid symbol
     */
    @Test
    void testValid() {
        assert !apiDataAccess.getSearchHistories().containsKey(validSymbol);
        assertNull(apiDataAccess.search(validSymbol, defaultSetting));
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

    /**
     * Search an invalid symbol
     */
    @Test
    void testInvalid() {
        assertEquals(apiDataAccess.search(invalidSymbol, defaultSetting),
                String.format("%s is not a valid symbol. Please enter a correct stock symbol.", invalidSymbol));
        assertNull(apiDataAccess.getStock(invalidSymbol));
    }

    /**
     * Search an empty symbol
     */
    @Test
    void testEmpty() {
        assertEquals(apiDataAccess.search(emptySymbol, defaultSetting),
                String.format("%s is not a valid symbol. Please enter a correct stock symbol.", emptySymbol));
        assertNull(apiDataAccess.getStock(emptySymbol));
    }

    /**
     * Only valid stock has been store in the searchHistory
     */
    @Test
    void testSearchHistory() {
        assert apiDataAccess.getSearchHistories().containsKey(validSymbol);
        assert !apiDataAccess.getSearchHistories().containsKey(invalidSymbol);
        assert !apiDataAccess.getSearchHistories().containsKey(emptySymbol);
    }

    /**
     * Reach the per minute limit
     */
    @AfterAll
    static void testFrequentRequest() {
        assertEquals(apiDataAccess.search(validSymbol2, defaultSetting),
                "Frequent request. Please try again in one minute.");
    }
}