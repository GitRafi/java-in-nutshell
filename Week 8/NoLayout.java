import javax.swing.*;
import java.awt.*;

class checkbox extends JFrame {
    
        Checkbox satu = new Checkbox("What's your name?");
        Checkbox dua = new Checkbox("My name is dizz");
        Checkbox tiga = new Checkbox("Dizz who?");
        CheckboxGroup checkboxGroup = new CheckboxGroup();

        checkbox() {
                super("Penghitung Dosa");
                setLocation(200, 100);
                setSize(400, 350);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        void object() {
                getContentPane().setLayout(null);
                getContentPane().add(satu);
                getContentPane().add(dua);
                getContentPane().add(tiga);
                satu.setBounds(30, 90, 150, 20);
                dua.setBounds(30, 120, 150, 20);
                tiga.setBounds(30, 150, 150, 20);
                setVisible(true);
        }

        public static void main(String[] args) {
                checkbox cb = new checkbox();
                cb.object();
        }
    }

