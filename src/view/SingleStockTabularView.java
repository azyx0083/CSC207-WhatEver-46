package view;


import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.SingleStockTabularState;
import interface_adapter.single_stock.SingleStockViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SingleStockTabularView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Tabular";

    private final SingleStockViewModel singleStockViewModel;

    private final JTextField searchInputField = new JTextField(15);
    private final SingleStockController singleStockController;
    private final JButton search;
    private final JButton graphical;
    private final JButton signup;
    private final JButton login;

    public SingleStockTabularView(SingleStockViewModel singleStockViewModel,
                                  SingleStockController singleStockController) {
        this.singleStockViewModel = singleStockViewModel;
        this.singleStockController = singleStockController;
        singleStockViewModel.addPropertyChangeListener(this);
        SingleStockTabularState state = (SingleStockTabularState) singleStockViewModel.getSingleStockState();

        JLabel title = new JLabel(state.getName());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel symbol = new JLabel(state.getSymbol());

        search = new JButton(SingleStockViewModel.SEARCH_BUTTON_LABEL);
        ButtonTextPanel searchPanel = new ButtonTextPanel(search, searchInputField);

        JPanel topButtons = new JPanel();
        signup = new JButton(SingleStockViewModel.SIGNUP_BUTTON_LABEL);
        topButtons.add(signup);
        login = new JButton(SingleStockViewModel.LOGIN_BUTTON_LABEL);
        topButtons.add(login);
        topButtons.setAlignmentX(Component.TOP_ALIGNMENT);

        JTable table = new JTable(state.getData(), state.getColumnNames());

        JPanel bottomButtons = new JPanel();
        graphical = new JButton(SingleStockViewModel.GRAPHICAL_BUTTON_LABEL);
        bottomButtons.add(graphical);
        bottomButtons.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        search.addActionListener(null);

        signup.addActionListener(null);

        login.addActionListener(null);

        graphical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(graphical)) {
                    SingleStockState currState = singleStockViewModel.getSingleStockState();
                    singleStockController.execute(currState.getSymbol(), "graphical");
                }
            }
        });

        searchInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        String text = searchInputField.getText() + e.getKeyChar();
                        ;
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(symbol);
        this.add(searchPanel);
        this.add(topButtons);
        this.add(table);
        this.add(bottomButtons);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
