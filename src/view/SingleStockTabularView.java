package view;

import interface_adapter.menu.MenuController;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;
import interface_adapter.single_stock.tabular.StockPriceTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Visualize the data of one stock in tabular form.
 */
public class SingleStockTabularView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "tabular";

    private final SingleStockTabularViewModel singleStockViewModel;
    private final SingleStockController singleStockController;
    private final MenuController menuController;
    private final JButton graphical;
    private final JButton menu;
    private final JLabel title;
    private final JLabel currentPrice;
    private final JLabel detail;
    private final JTable table;

    /**
     * Initializing a tabular display of a single stock.
     * @param singleStockViewModel the data structure that stores all information for the construction of this view
     * @param singleStockController the interface adapter correspond to the graphical button
     * @param menuController the interface adapter correspond to the menu button
     */
    public SingleStockTabularView(SingleStockTabularViewModel singleStockViewModel,
                                  SingleStockController singleStockController,
                                  MenuController menuController) {
        this.singleStockViewModel = singleStockViewModel;
        this.singleStockController = singleStockController;
        this.menuController = menuController;
        singleStockViewModel.addPropertyChangeListener(this);

        // Create a buttons panel consists the graphical and menu buttons
        JPanel buttons = new JPanel();
        graphical = new JButton(SingleStockTabularViewModel.GRAPHICAL_BUTTON_LABEL);
        buttons.add(graphical);
        menu = new JButton(SingleStockTabularViewModel.MENU_BUTTON_LABEL);
        buttons.add(menu);
        buttons.setAlignmentY(BOTTOM_ALIGNMENT);

        // Create the three titles to display the general info of the stock
        title = new JLabel();
        title.setFont(SingleStockTabularViewModel.font1);
        title.setAlignmentX(CENTER_ALIGNMENT);
        currentPrice = new JLabel();
        currentPrice.setFont(SingleStockTabularViewModel.font2);
        currentPrice.setAlignmentX(CENTER_ALIGNMENT);
        detail = new JLabel();
        detail.setFont(SingleStockTabularViewModel.font3);
        detail.setAlignmentX(CENTER_ALIGNMENT);

        // Create the table to display historical prices of the stock
        table = new JTable();
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setPreferredSize(new Dimension(400, 600));

        // Click the menu button will lead to the menu usecase
        menu.addActionListener(e -> {
            if (e.getSource().equals(menu))
                menuController.execute();
        });

        // Click the graphical button will lead to the single stock graphical usecase
        graphical.addActionListener(e -> {
            if (e.getSource().equals(graphical)) {
                singleStockController.execute(singleStockViewModel.getState().getSymbol());
            }
        });

        // Set up the layout for current view
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(currentPrice);
        this.add(detail);
        tableScroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(tableScroll);
        this.add(buttons);
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
