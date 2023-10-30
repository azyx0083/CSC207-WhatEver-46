package view;

import interface_adapter.menu.MenuController;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.SingleStockTabularState;
import interface_adapter.single_stock.SingleStockViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SingleStockTabularView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Tabular";

    private final SingleStockViewModel singleStockViewModel;
    private final SingleStockController singleStockController;
    private final MenuController menuController;
    private final JButton graphical;
    private final JButton menu;

    public SingleStockTabularView(SingleStockViewModel singleStockViewModel,
                                  SingleStockController singleStockController,
                                  MenuController menuController) {
        this.singleStockViewModel = singleStockViewModel;
        this.singleStockController = singleStockController;
        this.menuController = menuController;
        singleStockViewModel.addPropertyChangeListener(this);

        SingleStockTabularState state = (SingleStockTabularState) singleStockViewModel.getSingleStockState();

        JLabel title = new JLabel(state.getName());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel symbol = new JLabel(state.getSymbol());

        JTable table = new JTable(state.getData(), state.getColumnNames());

        JPanel Buttons = new JPanel();
        menu = new JButton(SingleStockViewModel.MENU_BUTTON_LABEL);
        Buttons.add(menu);
        graphical = new JButton(SingleStockViewModel.GRAPHICAL_BUTTON_LABEL);
        Buttons.add(graphical);

        menu.addActionListener(null);

        graphical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(graphical)) {
                    SingleStockState currState = singleStockViewModel.getSingleStockState();
                    singleStockController.execute(currState.getSymbol(), "graphical");
                }
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(symbol);
        this.add(table);
        this.add(Buttons);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
