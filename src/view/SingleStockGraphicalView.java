package view;

import interface_adapter.menu.MenuController;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.graphical.SingleStockPriceDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SegmentedTimeline;
import view.helpers.SingleStockCandleStickRenderer;
import view.helpers.SingleStockPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

/**
 * Visualize the data of a stock in graphical form.
 */
public class SingleStockGraphicalView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "graphical";
    final JButton menu;
    final JLabel title;
    final JLabel detail;
    final JLabel currentPrice;
    final JFreeChart chart;

    /**
     * Construct a graphical display of a single stock.
     * @param viewModel the information needed to construct such a display.
     * @param singleStockControllers the map that contain all the controller that correspond to the buttons.
     *                               the keys are the same as button labels
     *                               the values are the corresponding controllers
     * @param menuController the interface that connect to the menu button.
     */
    public SingleStockGraphicalView(SingleStockGraphicalViewModel viewModel,
                                    Map<String, SingleStockController> singleStockControllers,
                                    MenuController menuController){
        // Initial setup
        viewModel.addPropertyChangeListener(this);

        // Setting up stock title and symbols
        title = new JLabel();
        title.setFont(SingleStockGraphicalViewModel.font1);
        currentPrice = new JLabel();
        currentPrice.setFont(SingleStockGraphicalViewModel.font2);
        detail = new JLabel();
        detail.setFont(SingleStockGraphicalViewModel.font3);

        // Setting up new buttons
        JPanel buttons = new JPanel();
        for (String label : SingleStockGraphicalViewModel.BUTTON_LABELS) {
            if (singleStockControllers.containsKey(label)) {
                JButton button = new JButton(label);
                button.addActionListener(e ->
                        singleStockControllers.get(label).execute(viewModel.getState().getSymbol()));
                buttons.add(button);
            }
        }
        menu = new JButton(SingleStockGraphicalViewModel.MENU_BUTTON_LABEL);
        buttons.add(menu);

        // Setting up the graph
        chart = ChartFactory.createCandlestickChart(null, "Time", "Price",
                new SingleStockPriceDataset(), false); // some chart is generated by the JFreeChart library in output data
        chart.getXYPlot().setRenderer(new SingleStockCandleStickRenderer());
        ((NumberAxis) chart.getXYPlot().getRangeAxis()).setAutoRangeIncludesZero(false);
        ((DateAxis) chart.getXYPlot().getDomainAxis()).setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
        ChartPanel chartPanel = new ChartPanel(chart);

        // Switching to menu
        menu.addActionListener(e -> {
            if (e.getSource().equals(menu))
                menuController.returnToMenu();
        });

        // Adding buttons and setting layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new SingleStockPanel(title, currentPrice, detail, chartPanel, buttons));

    }

    /**
     * Refresh the current view using a new evt value.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SingleStockState state = (SingleStockState) evt.getNewValue();

        title.setText(state.getTitle());
        currentPrice.setText(state.getCurrentPrice());
        detail.setText(state.getDetail());
        chart.getXYPlot().setDataset((SingleStockPriceDataset)state.getData());

        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
