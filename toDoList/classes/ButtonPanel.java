package classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.Component;

public class ButtonPanel extends JPanel {

    private JButton addTask;
    private JButton clear;

    private Border emptyBorder = BorderFactory.createEmptyBorder();

    ButtonPanel() {
        this.setPreferredSize(new Dimension(400, 60));
        this.setBackground(new Color(240, 240, 240)); // Light gray background

        // Create and style Add Task button
        addTask = new JButton("Add Task");
        addTask.setBorder(emptyBorder);
        addTask.setFont(new Font("Sans-serif", Font.BOLD, 18)); // Bold font for better visibility
        addTask.setBackground(new Color(76, 175, 80)); // Green color
        addTask.setForeground(Color.WHITE); // White text
        addTask.setFocusPainted(false); // Remove focus border
        addTask.setOpaque(true); // Make background opaque
        addTask.setPreferredSize(new Dimension(150, 40)); // Set button size
        addTask.setBorder(new RoundedBorder(20)); // Use custom rounded border

        this.add(addTask);

        // Spacer between buttons
        this.add(Box.createHorizontalStrut(20));

        // Create and style Clear button
        clear = new JButton("Clear Completed Tasks");
        clear.setBorder(emptyBorder);
        clear.setFont(new Font("Sans-serif", Font.BOLD, 18)); // Bold font for better visibility
        clear.setBackground(new Color(244, 67, 54)); // Red color
        clear.setForeground(Color.WHITE); // White text
        clear.setFocusPainted(false); // Remove focus border
        clear.setOpaque(true); // Make background opaque
        clear.setPreferredSize(new Dimension(200, 40)); // Set button size
        clear.setBorder(new RoundedBorder(20)); // Use custom rounded border

        this.add(clear);
    }

    public JButton getAddTask() {
        return addTask;
    }

    public JButton getClear() {
        return clear;
    }

    // Custom rounded border class
    private static class RoundedBorder extends AbstractBorder {
        private final int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(c.getBackground());
            g2d.fillRoundRect(x, y, width, height, radius, radius);
            g2d.setColor(Color.GRAY); // Border color
            g2d.drawRoundRect(x, y, width, height, radius, radius);
            g2d.dispose();
        }

        public Dimension getPreferredSize(Component c) {
            return new Dimension(radius * 2, radius * 2);
        }
    }
}
