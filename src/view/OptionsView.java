package view;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.single_stock.SingleStockController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class OptionsView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "Search";
    private final SearchViewModel searchViewModel;
    private final Map<String, SingleStockController> map;
    private final String[] labelList;
    private final JLabel stockSymbol;
    private final JLabel stockName;
    public OptionsView(SearchViewModel searchViewModel,
                       Map<String, SingleStockController> map){
        this.searchViewModel = searchViewModel;
        this.map = map;
        this.labelList = SearchViewModel.LABEL;
        searchViewModel.addPropertyChangeListener(this);


        //creat buttons for graphical view and tabular view
        JPanel buttons = new JPanel();
        for (String x: labelList) {
            JButton button = new JButton(x);
            buttons.add(button);
            button.addActionListener(e -> {
                if (e.getSource().equals(button)){
                    SearchState currentState = searchViewModel.getState();
                    map.get(x).execute(currentState.getSymbol());
                }
            });
        }

        //creat the label contains symbol that user searched
        stockSymbol = new JLabel();
        stockSymbol.setFont(SearchViewModel.font2);
        stockSymbol.setAlignmentX(CENTER_ALIGNMENT);
        stockName = new JLabel();
        stockName.setFont(SearchViewModel.font1);
        stockName.setAlignmentX(CENTER_ALIGNMENT);


        //create the actual window and set the display size and content
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.ipady = 10;
        constraints.insets = new Insets(100, 100, 0, 100);
        constraints.gridy = 0;
        this.add(stockName, constraints);
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(stockSymbol, constraints);

        constraints.gridy = 2;
        constraints.weighty = 0.5;
        this.add(buttons, constraints);
    }
    //let the app actually show the stock symbol
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchState state = (SearchState) evt.getNewValue();
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