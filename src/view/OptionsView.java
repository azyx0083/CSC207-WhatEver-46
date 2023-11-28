package view;
import interface_adapter.search.OptionsState;
import interface_adapter.search.OptionsViewModel;
import interface_adapter.single_stock.SingleStockController;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class OptionsView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "Search";
    private final OptionsViewModel optionsViewModel;
    private final Map<String, SingleStockController> map;
    private final String[] labelList;
    private final JLabel stockSymbol;
    public OptionsView(OptionsViewModel optionsViewModel,
                       Map<String, SingleStockController> map){
        this.optionsViewModel = optionsViewModel;
        this.map = map;
        this.labelList = OptionsViewModel.LABEL;
        optionsViewModel.addPropertyChangeListener(this);


        //creat buttons for graphical view and tabular view
        JPanel buttons = new JPanel();
        for (String x: labelList) {
            JButton button = new JButton(x);
            buttons.add(button);
            button.addActionListener(e -> {
                if (e.getSource().equals(button)){
                    OptionsState currentState = optionsViewModel.getState();
                    map.get(x).execute(currentState.getSymbol());
                }
            });
        }

        //creat the label contains symbol that user searched
        stockSymbol = new JLabel();
        stockSymbol.setFont(optionsViewModel.font2);
        stockSymbol.setAlignmentX(CENTER_ALIGNMENT);


        //create the actual window and set the display size and content
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.add(stockSymbol);
        this.add(buttons);
    }
    //let the app actually show the stock symbol
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        OptionsState state = (OptionsState) evt.getNewValue();
        if (state.getSymbolError() != null) {
            JOptionPane.showMessageDialog(this, state.getSymbolError());
        }else{
            stockSymbol.setText(state.getSymbol());
            this.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}