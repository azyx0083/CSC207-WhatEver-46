package view.helpers;

import javax.swing.*;

public class LabelTextPanel extends JPanel{
    public LabelTextPanel(JLabel label, JTextField field) {
        this.add(label);
        this.add(field);
    }
}
