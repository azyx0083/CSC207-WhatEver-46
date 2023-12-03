package view.helpers;

import javax.swing.*;

/**
 * A panel containing a text field and a button.
 */
public class TextButtonPanel extends JPanel {
    public TextButtonPanel(JLabel label, JTextField textField, JButton button) {
        this.add(label);
        this.add(textField);
        this.add(button);
    }
}
