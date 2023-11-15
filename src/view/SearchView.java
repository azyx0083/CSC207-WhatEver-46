package view;
import interface_adapter.single_stock.graphical.SingleStockGraphicalController;
import interface_adapter.single_stock.tabular.SingleStockTabularController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "Search";
    private final SearchViewModel searchViewModel;
    private final SingleStockTabularController singleStockTabularController;
    private final SingleStockGraphicalController singleStockGraphicalController;
    private final JButton table;
    private final JButton graph;
    private final JLabel stockName;
    private final JLabel stockSymbol;
    public SearchView(SearchViewModel searchViewModel,
                      SingleStockTabularController singleStockTabularController,
                      SingleStockGraphicalController singleStockGraphicalController){
        this.searchViewModel = searchViewModel;
        this.singleStockTabularController = singleStockTabularController;
        this.singleStockGraphicalController = singleStockGraphicalController;
        searchViewModel.addPropertyChangeListener(this);

        //creat buttons for graphical view and tabular view
        JPanel buttons = new JPanel();
        graph = new JButton(searchViewModel.GRAPH_BUTTON_LABEL);
        buttons.add(graph);
        table = new JButton(searchViewModel.TABLE_BUTTON_LABEL);
        buttons.add(table);

        //creat the label contains name and symbol that user searched
        stockName = new JLabel();
        stockName.setFont(searchViewModel.font1);
        stockName.setAlignmentX(CENTER_ALIGNMENT);
        stockSymbol = new JLabel();
        stockSymbol.setFont(searchViewModel.font2);
        stockSymbol.setAlignmentX(CENTER_ALIGNMENT);

        //when graph button was clicked, call the graphical controller and visualizing the data
        //by graph
        graph.addActionListener(e -> {
            if (e.getSource().equals(graph)){
                singleStockGraphicalController.execute();
            }
        });
        //when table button was clicked, call the tabular controller and visualizing the data
        //by table
        table.addActionListener(e -> {
            if (e.getSource().equals(table)){
                singleStockTabularController.execute();
            }
        });
        //create the actual window and set the display size and content
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.add(stockName);
        this.add(stockSymbol);
        this.add(buttons);
    }
}
