package interface_adapter.single_stock.graphical;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.OHLCDataset;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StockPriceDataset implements OHLCDataset{
    private HashMap<String, Object[]> data;
    private OHLCSeriesCollection dataset = new OHLCSeriesCollection();

    public StockPriceDataset(HashMap<String, Object[]> data) {
        this.data = data;
    }

    @Override
    public Number getHigh(int i, int i1) {
        return (Number) data.get("high")[0];
    }

    @Override
    public double getHighValue(int i, int i1) {
        return (double)data.get("high")[0];
    }

    @Override
    public Number getLow(int i, int i1) {
        return (Number) data.get("low")[i];
    }

    @Override
    public double getLowValue(int i, int i1) {
        return (double) data.get("low")[i];
    }

    @Override
    public Number getOpen(int i, int i1) {
        return (Number) data.get("open")[i];
    }

    @Override
    public double getOpenValue(int i, int i1) {
        return (double) data.get("open")[i];
    }

    @Override
    public Number getClose(int i, int i1) {
        return (Number) data.get("close")[i];
    }

    @Override
    public double getCloseValue(int i, int i1) {
        return (double) data.get("close")[i];
    }

    @Override
    public Number getVolume(int i, int i1) {
        return (Number) data.get("volume")[i];
    }

    @Override
    public double getVolumeValue(int i, int i1) {
        return (double) data.get("volume")[i];
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
