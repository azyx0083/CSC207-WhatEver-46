package view;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.single_stock.SingleStockController;
import interface_adapter.single_stock.SingleStockState;
import interface_adapter.single_stock.graphical.SingleStockGraphicalViewModel;
import interface_adapter.single_stock.tabular.SingleStockTabularViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "Search";
    private final SearchViewModel searchViewModel;
    private final SearchController searchController;
    private final SingleStockController singleStockGraphicalController;
    private final SingleStockController singleStockTabularController;
    private final JButton table;
    private final JButton graph;
    private final JLabel stockSymbol;
    private final JTextField searchInputField = new JTextField(15);
    public SearchView(SearchViewModel searchViewModel,
                      SearchController searchController,
                      SingleStockController singleStockGraphicalController,
                      SingleStockController singleStockTabularController){
        this.searchViewModel = searchViewModel;
        this.searchController = searchController;
        this.singleStockGraphicalController = singleStockGraphicalController;
        this.singleStockTabularController = singleStockTabularController;
        searchViewModel.addPropertyChangeListener(this);

        LabelTextPanel searchInfo = new LabelTextPanel(new JLabel("search"),
                searchInputField);

        //creat buttons for graphical view and tabular view
        JPanel buttons = new JPanel();
        graph = new JButton(searchViewModel.GRAPH_BUTTON_LABEL);
        buttons.add(graph);
        table = new JButton(searchViewModel.TABLE_BUTTON_LABEL);
        buttons.add(table);

        //creat the label contains symbol that user searched
        stockSymbol = new JLabel();
        stockSymbol.setFont(searchViewModel.font2);
        stockSymbol.setAlignmentX(CENTER_ALIGNMENT);

        //when graph button was clicked, call the graphical controller and visualizing the data
        //by graph
        graph.addActionListener(e -> {
            if (e.getSource().equals(graph)){
                SearchState currentState = searchViewModel.getState();
                singleStockGraphicalController.execute(currentState.getSymbol());
            }
        });
        //when table button was clicked, call the tabular controller and visualizing the data
        //by table
        table.addActionListener(e -> {
            if (e.getSource().equals(table)){
                SearchState currentState = searchViewModel.getState();
                singleStockTabularController.execute(currentState.getSymbol());
            }
        });
        searchInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                SearchState currentState = searchViewModel.getState();
                String text = searchInputField.getText() + e.getKeyChar();
                currentState.setSymbol(text);
                searchViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        //create the actual window and set the display size and content
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.add(stockSymbol);
        this.add(buttons);
        this.add(searchInfo);
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