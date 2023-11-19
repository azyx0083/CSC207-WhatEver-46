package interface_adapter.single_stock.graphical;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.OHLCDataset;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StockPriceDataset extends DefaultXYDataset implements OHLCDataset{
    private HashMap<String, Object[]> data;
    private OHLCSeriesCollection dataset = new OHLCSeriesCollection();

    /**
     * initializing a map with given param
     * @param data the map that class need
     */
    public StockPriceDataset(HashMap<String, Object[]> data) {
        this.data = data;
    }

    /**
     * get the data and cast the type to Number from the initialized map with key "high"
     * @param i default param
     * @param i1 default param
     * @return data with type Number
     */
    @Override
    public Number getHigh(int i, int i1) {
        return (Number) data.get("high")[0];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "high"
     * @param i default param
     * @param i1 default param
     * @return data with type double
     */
    @Override
    public double getHighValue(int i, int i1) {
        return (double)data.get("high")[0];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "low"
     * @param i default param
     * @param i1 default param
     * @return data with type Number
     */
    @Override
    public Number getLow(int i, int i1) {
        return (Number) data.get("low")[0];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "low"
     * @param i default param
     * @param i1 default param
     * @return data with type double
     */
    @Override
    public double getLowValue(int i, int i1) {
        return (double) data.get("low")[0];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "open"
     * @param i default param
     * @param i1 default param
     * @return data with type Number
     */
    @Override
    public Number getOpen(int i, int i1) {
        return (Number) data.get("open")[0];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "open"
     * @param i default param
     * @param i1 default param
     * @return data with type double
     */
    @Override
    public double getOpenValue(int i, int i1) {
        return (double) data.get("open")[0];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "close"
     * @param i default param
     * @param i1 default param
     * @return data with type Number
     */
    @Override
    public Number getClose(int i, int i1) {
        return (Number) data.get("close")[0];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "close"
     * @param i default param
     * @param i1 default param
     * @return data with type double
     */
    @Override
    public double getCloseValue(int i, int i1) {
        return (double) data.get("close")[0];
    }
    /**
     * get the data and cast the type to Number from the initialized map with key "volume"
     * @param i default param
     * @param i1 default param
     * @return data with type Number
     */
    @Override
    public Number getVolume(int i, int i1) {
        return (Number) data.get("volume")[0];
    }
    /**
     * get the data and cast the type to double from the initialized map with key "volume"
     * @param i default param
     * @param i1 default param
     * @return data with type double
     */
    @Override
    public double getVolumeValue(int i, int i1) {
        return (double) data.get("volume")[0];
    }

    @Override
    public DomainOrder getDomainOrder() {
        return dataset.getDomainOrder();
    }

    @Override
    public int getItemCount(int i) {
        return dataset.getItemCount(i);
    }

    @Override
    public Number getX(int i, int i1) {
        return dataset.getX(i, i1);
    }

    @Override
    public double getXValue(int i, int i1) {
        return dataset.getXValue(i,i1);
    }

    @Override
    public Number getY(int i, int i1) {
        return dataset.getY(i,i1);
    }

    @Override
    public double getYValue(int i, int i1) {
        return dataset.getYValue(i, i1);
    }

    @Override
    public int getSeriesCount() {
        return dataset.getSeriesCount();
    }

    @Override
    public Comparable getSeriesKey(int i) {
        return dataset.getSeriesKey(i);
    }

    @Override
    public int indexOf(Comparable comparable) {
        return dataset.indexOf(comparable);
    }

    @Override
    public void addChangeListener(DatasetChangeListener datasetChangeListener) {
        dataset.addChangeListener(datasetChangeListener);
    }

    @Override
    public void removeChangeListener(DatasetChangeListener datasetChangeListener) {
        dataset.removeChangeListener(datasetChangeListener);
    }

    @Override
    public DatasetGroup getGroup() {
        return dataset.getGroup();
    }

    @Override
    public void setGroup(DatasetGroup datasetGroup) {
        dataset.setGroup(datasetGroup);
    }
}
