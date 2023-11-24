package view;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel for the visualization of single stock data
 */
public class SingleStockPanel extends JPanel {
    /**
     * Initialize a visualization of single stock using the data provided
     * @param title the title JLabel to be display
     * @param currentPrice the current price JLabel to be display
     * @param detail the detail JLabel to be display
     * @param visual the JComponent that visualize the stock data
     * @param buttons the JPanel that contain all the buttons
     */
    public SingleStockPanel(JLabel title, JLabel currentPrice, JLabel detail, JComponent visual, JPanel buttons) {
        // all components center aligned
        title.setAlignmentX(CENTER_ALIGNMENT);
        currentPrice.setAlignmentX(CENTER_ALIGNMENT);
        detail.setAlignmentX(CENTER_ALIGNMENT);
        buttons.setAlignmentX(CENTER_ALIGNMENT);

        // Set up the layout for all components
        // All views for the single stock use case can share this layout
        // buttons panel was created outside the class, so adding new buttons for new visualization won't result in changes in this file
        // Use the Abstract class JComponent so visual does not depend on the actual class used for each visualization
        // Apply Dependency Injection design pattern and Open/Closed Principle
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(currentPrice);
        this.add(detail);
        visual.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        visual.setPreferredSize(new Dimension(800, 600));
        this.add(visual);
        this.add(buttons);

    }
}
