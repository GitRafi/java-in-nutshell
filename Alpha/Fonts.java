import javax.swing.*;
import java.awt.*;

public class Fonts {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Available Fonts Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with BoxLayout for a vertical list of labels
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Get all available fonts
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();

        // Create a label for each font and add it to the panel
        for (String fontName : fontNames) {
            JLabel label = new JLabel(fontName);
            label.setFont(new Font(fontName, Font.PLAIN, 16)); // Apply each font
            panel.add(label); // Add label to the panel
        }

        // Wrap the panel in a JScrollPane and set the preferred size for scrolling
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 400)); // Set scroll pane size

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        // Pack and display the frame
        frame.pack();
        frame.setVisible(true);
    }
}
