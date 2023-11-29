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

    /**
     * Constructor method. Makes the view layout and assigns buttons their functionalities.
     * @param menuController The associated MenuController
     * @param menuViewModel The associated  MenuViewModel
     * /@param searchController The associated SearchController
     * /@param searchViewModel The associated SearchViewModel
     */
    public MenuView(MenuController menuController, MenuViewModel menuViewModel/*, SearchController searchController, SearchViewModel searchViewModel*/){
        this.menuController = menuController;
        this.menuViewModel = menuViewModel;

        this.setPreferredSize(new Dimension(400,200));

        JLabel title = new JLabel(MenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        if (menuViewModel.hasUser()){
            JLabel userLabel = new JLabel(MenuViewModel.USER_LABEL + menuViewModel.getState().getUsername());
        }

        JLabel searchLabel = new JLabel(MenuViewModel.SEARCH_LABEL);
        searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        search = new JButton(MenuViewModel.SEARCH_BUTTON_LABEL);
        search.setAlignmentX(Component.CENTER_ALIGNMENT);
        search.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(search)) {
                            MenuState menuState = menuViewModel.getState();

                            //searchController.executeStockSearch(menuState.getStockSymbol()); TODO uncomment after merge
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(searchLabel);
        this.add(Box.createRigidArea(new Dimension(5,10)));
        this.add(searchInputField);
        this.add(Box.createRigidArea(new Dimension(5,20)));
        this.add(search);
    }
}
