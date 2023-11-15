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

        JPanel buttons = new JPanel();
        graph = new JButton(searchViewModel.GRAPH_BUTTON_LABEL);
        buttons.add(graph);
        table = new JButton(searchViewModel.TABLE_BUTTON_LABEL);
        buttons.add(table);

        stockName = new JLabel();
        stockName.setFont(searchViewModel.font1);
        stockName.setAlignmentX(CENTER_ALIGNMENT);
        stockSymbol = new JLabel();
        stockSymbol.setFont(searchViewModel.font2);
        stockSymbol.setAlignmentX(CENTER_ALIGNMENT);

        graph.addActionListener(e -> {
            if (e.getSource().equals(graph)){
                singleStockGraphicalController.execute();
            }
        });

        table.addActionListener(e -> {
            if (e.getSource().equals(table)){
                singleStockTabularController.execute();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.add(stockName);
        this.add(stockSymbol);
        this.add(buttons);
    }
}
