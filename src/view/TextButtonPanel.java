package view;

import javax.swing.*;

/**
 * A panel containing a text field and a button.
 */
class TextButtonPanel extends JPanel {
    TextButtonPanel(JTextField textField, JButton button) {
        this.add(textField);
        this.add(button);
    }
}
