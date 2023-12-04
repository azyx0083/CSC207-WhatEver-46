package interface_adapter.single_stock.graphical;

import interface_adapter.single_stock.SingleStockPriceData;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.OHLCDataset;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * this class will act like DefaultOHLCDataset, the different is this class will take HashMap
 * as the input and constructor doesn't require Key and Date.
 */
public class SingleStockPriceDataset extends AbstractXYDataset implements OHLCDataset, SingleStockPriceData {
    private Map<String, Object[]> data = new HashMap<>();

    /**
     * initializing a map with given param
     *
     */
    public SingleStockPriceDataset() {}

    @Override
    public int getSeriesCount() {
        return 1;
    }

    @Override
    public Comparable getSeriesKey(int i) {
        return "data";
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
        return (float)data.get("high")[i1];
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
        return (float) data.get("low")[i1];
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
        return (float) data.get("open")[i1];
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
        return (float) data.get("close")[i1];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "volume"
     * @param i series
     * @param i1 index of item needed
     * @return data with type Number
     */
    @Override
    public Number getVolume(int i, int i1) {
        return (int) data.get("volume")[i1];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "volume"
     * @param i series
     * @param i1 index of item needed
     * @return data with type double
     */
    @Override
    public double getVolumeValue(int i, int i1) {
        return (int) data.get("volume")[i1];
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date).getTime();
        } catch (ParseException ignore) {
            try {
                return format2.parse(date).getTime();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
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
    public SingleStockPriceData updateData(Map<String, Object[]> data) {
        this.data = data;
        return this;
    }

    @Override
    public Map<String, Object[]> getData() {
        return this.data;
    }
}