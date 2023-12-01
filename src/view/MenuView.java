package view;

import interface_adapter.menu.*;
import interface_adapter.search.*;
import interface_adapter.single_stock.SingleStockState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "menu";
    final MenuController menuController;
    final MenuViewModel menuViewModel;
    final SearchController searchController;
    final SearchViewModel searchViewModel;
    private final JTextField searchInputField = new JTextField(20);
    private final JButton search;

    /**
     * Constructor method. Makes the view layout and assigns buttons their functionalities.
     *
     * @param menuController The associated MenuController
     * @param menuViewModel  The associated  MenuViewModel
     *                       /@param searchController The associated SearchController
     *                       /@param searchViewModel The associated SearchViewModel
     */
    public MenuView(MenuController menuController, MenuViewModel menuViewModel, SearchController searchController, SearchViewModel searchViewModel) {
        this.menuController = menuController;
        this.menuViewModel = menuViewModel;
        this.searchController = searchController;
        this.searchViewModel = searchViewModel;

        this.setPreferredSize(new Dimension(200, 200));

        JLabel title = new JLabel(MenuViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

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

                            searchController.execute(menuState.getStockSymbol());
                        }
                    }
                }
        );

        searchInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        MenuState currentState = menuViewModel.getState();
                        String text = searchInputField.getText() + e.getKeyChar();
                        currentState.setStockSymbol(text);
                        menuViewModel.setState(currentState);
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
        this.add(searchLabel);
        this.add(Box.createRigidArea(new Dimension(5, 10)));
        this.add(searchInputField);
        this.add(Box.createRigidArea(new Dimension(5, 20)));
        this.add(search);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MenuState state = (MenuState) evt.getNewValue();

        searchInputField.setText(state.getStockSymbol());
        this.repaint();
    }
}
