package view;

import interface_adapter.menu.MenuController;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import interface_adapter.single_stock.tabular.StockPriceTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

/**
 * Visualize the data of one stock in tabular form.
 */
public class SingleStockTabularView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "tabular";
    private final JButton menu;
    private final JLabel title;
    private final JLabel currentPrice;
    private final JLabel detail;
    private final JTable table;

    /**
     * Initializing a tabular display of a single stock.
     * @param singleStockViewModel the data structure that stores all information for the construction of this view
     * @param singleStockControllers the map that contain all the controller that correspond to the buttons.
     *                              the keys are the same as button labels
     *                              the values are the corresponding controllers
     * @param menuController the interface adapter correspond to the menu button
     */
    public SingleStockTabularView(SingleStockTabularViewModel singleStockViewModel,
                                  Map<String, SingleStockController> singleStockControllers,
                                  MenuController menuController) {
        singleStockViewModel.addPropertyChangeListener(this);

        // Create a buttons panel consists the graphical and menu buttons
        JPanel buttons = new JPanel();
        for (String label : SingleStockTabularViewModel.BUTTON_LABELS) {
            if (singleStockControllers.containsKey(label)) {
                JButton button = new JButton(label);
                button.addActionListener(e ->
                        singleStockControllers.get(label).execute(singleStockViewModel.getState().getSymbol()));
                buttons.add(button);
            }
        }
        menu = new JButton(SingleStockTabularViewModel.MENU_BUTTON_LABEL);
        buttons.add(menu);

        // Create the three titles to display the general info of the stock
        title = new JLabel();
        title.setFont(SingleStockTabularViewModel.font1);
        currentPrice = new JLabel();
        currentPrice.setFont(SingleStockTabularViewModel.font2);
        detail = new JLabel();
        detail.setFont(SingleStockTabularViewModel.font3);

        // Create the table to display historical prices of the stock
        table = new JTable();
        JScrollPane tableScroll = new JScrollPane(table);

        // Click the menu button will lead to the menu usecase
        menu.addActionListener(e -> {
            if (e.getSource().equals(menu))
                menuController.returnToMenu();
        });

        // Set up the layout for current view
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new SingleStockPanel(title, currentPrice, detail, tableScroll, buttons));
    }

    /**
     * Update the current view using the new value of PropertyChangeEvert evt.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SingleStockState state = (SingleStockState) evt.getNewValue();

        // Reassign the JLabel for all three titles and the JTable for historical prices
        title.setText(state.getTitle());
        currentPrice.setText(state.getCurrentPrice());
        detail.setText(state.getDetail());

        table.setModel((StockPriceTableModel)state.getData());

        // Repaint to refresh
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
