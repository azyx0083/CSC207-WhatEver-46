package view;

import interface_adapter.menu.MenuController;
import interface_adapter.single_stock.tabular.SingleStockTabularController;
import interface_adapter.single_stock.tabular.SingleStockTabularState;
import interface_adapter.single_stock.SingleStockViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SingleStockTabularView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "tabular";

    private final SingleStockViewModel singleStockViewModel;
    private final SingleStockTabularController singleStockController;
    private final MenuController menuController;
    private final JButton graphical;
    private final JLabel title;
    private final JLabel currentPrice;
    private final JLabel detail;
    private final JTable table;

    public SingleStockTabularView(SingleStockViewModel singleStockViewModel,
                                  SingleStockTabularController singleStockController,
                                  MenuController menuController) {
        this.singleStockViewModel = singleStockViewModel;
        this.singleStockController = singleStockController;
        this.menuController = menuController;
        singleStockViewModel.addPropertyChangeListener(this);

        JPanel buttons = new JPanel();
        graphical = new JButton(SingleStockViewModel.GRAPHICAL_BUTTON_LABEL);
        buttons.add(graphical);
        JButton menu = new JButton(SingleStockViewModel.MENU_BUTTON_LABEL);
        buttons.add(menu);

        title = new JLabel();
        title.setFont(new Font("Serif", Font.BOLD, 18));
        title.setAlignmentX(CENTER_ALIGNMENT);
        currentPrice = new JLabel();
        currentPrice.setFont(new Font("Serif", Font.BOLD, 20));
        currentPrice.setAlignmentX(CENTER_ALIGNMENT);
        detail = new JLabel();
        detail.setFont(new Font("Serif", Font.PLAIN, 14));
        detail.setAlignmentX(CENTER_ALIGNMENT);

        table = new JTable();

        menu.addActionListener(null);

        graphical.addActionListener(e -> {
            if (e.getSource().equals(graphical)) {
                singleStockController.execute();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(currentPrice);
        this.add(detail);
        this.add(new JScrollPane(table));
        this.add(buttons);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SingleStockTabularState state = (SingleStockTabularState) evt.getNewValue();

        title.setText(state.getTitle());
        currentPrice.setText(state.getCurrentPrice());
        detail.setText(state.getDetail());

        table.setModel(state.getData());

        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
