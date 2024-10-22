import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EHandlerButton extends JFrame {
    JButton button = new JButton("Tekan key 1-4");
    JLabel msg = new JLabel("Frame size akan berubah");

    EHandlerButton() {
        setTitle("EventHandler Keyboard");
        setSize(400, 200);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void component() {
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(button);
        getContentPane().add(msg);
        setVisible(true);
    }
    
    void key_listener() {
        button.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent press) {
                if (press.getKeyCode() == KeyEvent.VK_1) {
                   setSize(200, 200); 
                }
            if (press.getKeyCode() == KeyEvent.VK_2) {
                   setSize(300, 300); 
                }
                if (press.getKeyCode() == KeyEvent.VK_3) {
                   setSize(400, 400); 
                }
                if (press.getKeyCode() == KeyEvent.VK_4) {
                   setSize(500, 500); 
                }
            }
        });
    }
        
    public static void main(String[] args) {
        EHandlerButton e = new EHandlerButton();
        e.component();
        e.key_listener();         
    }
}
