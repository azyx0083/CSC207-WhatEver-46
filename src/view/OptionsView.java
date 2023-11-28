package view;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.single_stock.SingleStockController;


import javax.swing.*;
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
        stockSymbol.setFont(searchViewModel.font2);
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