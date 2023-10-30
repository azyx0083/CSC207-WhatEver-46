package entity;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.OHLCDataset;

import java.util.List;

public class StockPriceDataset implements OHLCDataset{
    private List<StockPrice> prices;

    public StockPriceDataset(List<StockPrice> prices) {
        this.prices = prices;
    }

    @Override
    public Number getHigh(int i, int i1) {
        return prices.get(i).getHigh();
    }

    @Override
    public double getHighValue(int i, int i1) {
        return 0;
    }

    @Override
    public Number getLow(int i, int i1) {
        return prices.get(i).getLow();
    }

    @Override
    public double getLowValue(int i, int i1) {
        return 0;
    }

    @Override
    public Number getOpen(int i, int i1) {
        return prices.get(i).getOpen();
    }

    @Override
    public double getOpenValue(int i, int i1) {
        return 0;
    }

    @Override
    public Number getClose(int i, int i1) {
        return prices.get(i).getClose();
    }

    @Override
    public double getCloseValue(int i, int i1) {
        return 0;
    }

    @Override
    public Number getVolume(int i, int i1) {
        return prices.get(i).getVolume();
    }

    @Override
    public double getVolumeValue(int i, int i1) {
        return 0;
    }

    @Override
    public DomainOrder getDomainOrder() {
        return null;
    }

    @Override
    public int getItemCount(int i) {
        return 0;
    }

    @Override
    public Number getX(int i, int i1) {
        return null;
    }

    @Override
    public double getXValue(int i, int i1) {
        return 0;
    }

    @Override
    public Number getY(int i, int i1) {
        return null;
    }

    @Override
    public double getYValue(int i, int i1) {
        return 0;
    }

    @Override
    public int getSeriesCount() {
        return 0;
    }

    @Override
    public Comparable getSeriesKey(int i) {
        return null;
    }

    @Override
    public int indexOf(Comparable comparable) {
        return 0;
    }

    @Override
    public void addChangeListener(DatasetChangeListener datasetChangeListener) {

    }

    @Override
    public void removeChangeListener(DatasetChangeListener datasetChangeListener) {

    }

    @Override
    public DatasetGroup getGroup() {
        return null;
    }

    @Override
    public void setGroup(DatasetGroup datasetGroup) {

    }
}
