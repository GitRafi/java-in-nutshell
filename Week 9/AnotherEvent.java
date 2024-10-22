import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AnotherEvent extends JFrame {

    //Set element
    JTextArea name = new JTextArea(10, 10);
    JButton button = new JButton("Copy");
    JTextArea txname = new JTextArea(10, 10);

    AnotherEvent() {
        super("Test Event Handling");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void panel() {
        getContentPane().add(name);
        name.append("What's your name sir?");
        getContentPane().add(button);
        getContentPane().add(txname);
        txname.setBackground(Color.LIGHT_GRAY);
        getContentPane().setLayout(new FlowLayout());
        setVisible(true);
    }

    void event_listener() {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txname.append(name.getSelectedText());
            }
        });
    }

    public static void main(String[] args) {
        AnotherEvent ae = new AnotherEvent();
        ae.panel();
        ae.event_listener();
    }
    
}
