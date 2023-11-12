package view;

import interface_adapter.menu.*;
import use_case.menu.MenuInputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView {
    public final String viewName = "menu";
    final MenuController menuController;
    //final SearchController searchController; TODO uncomment once implemented
    private final JTextField searchInputField = new JTextField(20);
    private final JButton search;
    public MenuView(MenuController menuController, MenuViewModel menuViewModel){
        this.menuController = menuController;

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
    }
}
