package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class ButtonTextPanel extends JPanel {
    ButtonTextPanel(JButton button, JTextField textField) {
        this.add(button);
        this.add(textField);
    }
}
