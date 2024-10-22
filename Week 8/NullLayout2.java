import javax.swing.*;
import java.awt.*;

class NullLayout2 extends JFrame {
    Button cb1 = new Button("Pilih A");
    Button cb2 = new Button("Pilih B");
    Button cb3 = new Button("Pilih C");

    NullLayout2() {
        setTitle("Program GUI Swing");
        setLocation(200,100);
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.gray);
        cb1.setBackground(Color.RED);
        cb2.setBackground(Color.BLUE);
        cb3.setBackground(Color.YELLOW);
        getContentPane().add(cb1);
        getContentPane().add(cb2);
        getContentPane().add(cb3);
        cb1.setBounds(30, 90, 150, 20);
        cb2.setBounds(30, 120, 150, 20);
        cb3.setBounds(30, 150, 150, 20);
        setVisible(true);
    }    

    public static void main(String[] args) {
        NullLayout2 n = new NullLayout2();
        n.object();
    }
}
