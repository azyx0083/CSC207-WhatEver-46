package interface_adapter.single_stock.graphical;

import interface_adapter.single_stock.SingleStockData;
import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.OHLCDataset;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * this class will act like DefaultOHLCDataset, the different is this class will take HashMap
 * as the input and constructor doesn't require Key and Date.
 */
public class StockPriceDataset extends AbstractXYDataset implements OHLCDataset, SingleStockData {
    private HashMap<String, Object[]> data;

    /**
     * initializing a map with given param
     *
     */
    public StockPriceDataset() {}

    @Override
    public int getSeriesCount() {
        return 0;
    }

    @Override
    public Comparable getSeriesKey(int i) {
        return null;
    }

    /**
     * get the data and cast the type to Number from the initialized map with key "high"
     * @param i series
     * @param i1 index of item needed
     * @return data with type Number
     */
    @Override
    public Number getHigh(int i, int i1) {
        return (Number) data.get("high")[i1];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "high"
     * @param i series
     * @param i1 index of item needed
     * @return data with type double
     */
    @Override
    public double getHighValue(int i, int i1) {
        return (double)data.get("high")[i1];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "low"
     * @param i series
     * @param i1 index of item needed
     * @return data with type Number
     */
    @Override
    public Number getLow(int i, int i1) {
        return (Number) data.get("low")[i1];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "low"
     * @param i series
     * @param i1 index of item needed
     * @return data with type double
     */
    @Override
    public double getLowValue(int i, int i1) {
        return (double) data.get("low")[i1];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "open"
     * @param i series
     * @param i1 index of item needed
     * @return data with type Number
     */
    @Override
    public Number getOpen(int i, int i1) {
        return (Number) data.get("open")[i1];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "open"
     * @param i series
     * @param i1 index of item needed
     * @return data with type double
     */
    @Override
    public double getOpenValue(int i, int i1) {
        return (double) data.get("open")[i1];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "close"
     * @param i series
     * @param i1 index of item needed
     * @return data with type Number
     */
    @Override
    public Number getClose(int i, int i1) {
        return (Number) data.get("close")[i1];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "close"
     * @param i series
     * @param i1 index of item needed
     * @return data with type double
     */
    @Override
    public double getCloseValue(int i, int i1) {
        return (double) data.get("close")[i1];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "volume"
     * @param i series
     * @param i1 index of item needed
     * @return data with type Number
     */
    @Override
    public Number getVolume(int i, int i1) {
        return (Number) data.get("volume")[i1];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "volume"
     * @param i series
     * @param i1 index of item needed
     * @return data with type double
     */
    @Override
    public double getVolumeValue(int i, int i1) {
        return (double) data.get("volume")[i1];
    }
    

    @Override
    public int getItemCount(int i) {
        if(data.isEmpty()){
            return 0;
        } else {
            return data.get("open").length;
        }
    }

    @Override
    public Number getX(int i, int i1) {
        String date = (String) data.get("date")[i1];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date).getTime();
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public double getXValue(int i, int i1) {
        return super.getXValue(i, i1);
    }

    @Override
    public Number getY(int i, int i1) {
        return this.getClose(i, i1);
    }

    @Override
    public SingleStockData updateData(Map<String, Object[]> data) {
        this.data = (HashMap)data;
        return this;
    }
}