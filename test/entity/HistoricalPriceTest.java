package entity;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class HistoricalPriceTest {
    static Map<String, Object> testData = Map.of("date", "2020-01-01", "open", 0.1f, "high", 0.2f,
            "low", 0.3f, "close", 0.4f, "volume", 100);

    @Test
    void testNewHistoricalPrice() {
        for (int i = 0; i < 10; i ++) {
            HistoricalPrice historicalPrice = new HistoricalPrice(i);
            Map<String, Object[]> prices = historicalPrice.getPrices();
            for (String s : testData.keySet()) {
                assert prices.containsKey(s);
            }
            for (Object[] data : prices.values()) {
                assert data.length == i;
            }
        }
    }

    @Test
    void testAddPrice() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
        HistoricalPrice historicalPrice = new HistoricalPrice(randomNum);
        for (int i = 0; i < randomNum; i++) {
            historicalPrice.addPrice(i, (String)testData.get("date") , (float)testData.get("open"), (float)testData.get("close"),
                    (float)testData.get("high"),(float)testData.get("low"), (int)testData.get("volume"));
            Map<String, Object[]> prices = historicalPrice.getPrices();
            for (String s : testData.keySet()) {
                assertEquals(prices.get(s)[i], testData.get(s));
            }
        }
    }
}