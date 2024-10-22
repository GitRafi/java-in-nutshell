import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandler {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        final JLabel lb = new JLabel();
        final String[] items = {"Roti", "Madu"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        JPanel panel = new JPanel();
        jf.add(panel, BorderLayout.WEST);
        panel.add(comboBox, BorderLayout.WEST);
        panel.add(lb, BorderLayout.NORTH);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String mn = (String) comboBox.getSelectedItem();
                lb.setText(mn);
            }
        });
        jf.setSize(200, 200);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}