import javax.swing.*;
import java.awt.*;

class SwingTwo extends JFrame {
    Button cb1 = new Button("Pilih A");
    Button cb2 = new Button("Pilih B");

    SwingTwo() {
        setTitle("Program GUI Swing");
        setLocation(200,100);
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void object() {
        getContentPane().setLayout(new FlowLayout());
        getContentPane().setBackground(Color.gray);
        cb1.setBackground(Color.RED);
        cb2.setBackground(Color.BLUE);
        getContentPane().add(cb1);
        getContentPane().add(cb2);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingTwo st = new SwingTwo();
        st.object();
    }
}
