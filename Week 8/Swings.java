import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swings extends JFrame {
    JTextArea nama = new JTextArea(10, 10);
    JButton bt = new JButton("Copy");
    JTextArea txnama = new JTextArea(10, 10);

    Swings() {
        super("FORM");
        setLocation(200, 300);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void tampilan() {
        getContentPane().add(nama);
        nama.append("What's your name?");
        getContentPane().add(bt);
        getContentPane().add(txnama);
        txnama.setBackground(Color.lightGray);
        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txnama.append(nama.getSelectedText());
            }
        });
        getContentPane().setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        Swings sw = new Swings();
        sw.tampilan();
    }
}
