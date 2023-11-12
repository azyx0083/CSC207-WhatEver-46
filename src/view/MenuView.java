package view;

import interface_adapter.menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel{
    public final String viewName = "menu";
    final MenuController menuController;
    final MenuViewModel menuViewModel;
    //final SearchController searchController; TODO uncomment once implemented
    //final SearchViewModel searchViewModel;
    private final JTextField searchInputField = new JTextField(20);
    private final JButton search;
    public MenuView(MenuController menuController, MenuViewModel menuViewModel/*, SearchController searchController, SearchViewModel searchViewModel*/){
        this.menuController = menuController;
        this.menuViewModel = menuViewModel;

        JLabel title = new JLabel(MenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel searchLabel = new JLabel(MenuViewModel.SEARCH_LABEL);


        search = new JButton(MenuViewModel.SEARCH_BUTTON_LABEL);
        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(search)) {
                            MenuState menuState = menuViewModel.getState();

                            menuController.executeStockSearch(menuState.getStockSymbol());
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(searchLabel);
        this.add(searchInputField);
        this.add(search);
    }
}
