package view.helpers;

import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.*;

public class SingleStockCandleStickRenderer extends CandlestickRenderer {
    public SingleStockCandleStickRenderer() {
        super();
        setUpPaint(new Color(0, 175, 0));
        setDownPaint(new Color(230, 0, 0));
    }

    @Override
    public Paint getItemPaint(int row, int column) {

        //determine up or down candle
        XYDataset dataset = getPlot().getDataset();
        OHLCDataset highLowData = (OHLCDataset) dataset;
        Number yOpen = highLowData.getOpen(row, column);
        Number yClose = highLowData.getClose(row, column);
        boolean isUpCandle = yClose.doubleValue() > yOpen.doubleValue();

        //return the same color as that used to fill the candle
        if (isUpCandle) {
            return getUpPaint();
        }
        else {
            return getDownPaint();
        }
    }

}
