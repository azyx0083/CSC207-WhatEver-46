package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class TextButtonPanel extends JPanel {
    TextButtonPanel(JTextField textField, JButton button) {
        this.add(textField);
        this.add(button);
    }
}
