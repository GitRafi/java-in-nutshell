import javax.swing.*;
import java.awt.*;

class calc2 extends JFrame {
    TextField input = new TextField();
    Button no1 = new Button("1");
    Button no2 = new Button("2");
    Button no3 = new Button("3");
    Button no4 = new Button("4");
    Button no5 = new Button("5");
    Button no6 = new Button("6");
    Button no7 = new Button("7");
    Button no8 = new Button("8");
    Button no9 = new Button("9");
    Button no0 = new Button("0");
    Button c = new Button("c");
    Button equal = new Button("=");
    Button plus = new Button("+");
    Button minus = new Button("-");
    Button divide = new Button("/");
    Button multiply = new Button("*");

    calc2() {
        setTitle("Kalkulator Sederhana");
        setLocationRelativeTo(null);
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(input);
        getContentPane().add(no1);
        getContentPane().add(no2);
        getContentPane().add(no3);
        getContentPane().add(plus);
        getContentPane().add(no4);
        getContentPane().add(no5);
        getContentPane().add(no6);
        getContentPane().add(minus);
        getContentPane().add(no7);
        getContentPane().add(no8);
        getContentPane().add(no9);
        getContentPane().add(multiply);
        getContentPane().add(no0);
        getContentPane().add(c);
        getContentPane().add(equal);
        getContentPane().add(divide);
        
        //Color
        plus.setBackground(Color.CYAN);
        minus.setBackground(Color.GREEN);
        divide.setBackground(Color.RED);
        multiply.setBackground(Color.MAGENTA);

        //Posisi
        input.setBounds(13, 10, 260, 30);
        no1.setBounds(13, 50, 57, 30);
        no2.setBounds(82, 50, 57, 30);
        no3.setBounds(150, 50, 57, 30);
        plus.setBounds(216, 50, 57, 30);
        no4.setBounds(13, 90, 57, 30);
        no5.setBounds(82, 90, 57, 30);
        no6.setBounds(150, 90, 57, 30);
        minus.setBounds(216, 90, 57, 30);
        no7.setBounds(13, 130, 57, 30);
        no8.setBounds(82, 130, 57, 30);
        no9.setBounds(150, 130, 57, 30);
        multiply.setBounds(216, 130, 57, 30);
        no0.setBounds(13, 170, 57, 30);
        c.setBounds(82, 170, 57, 30);
        equal.setBounds(150, 170, 57, 30);
        divide.setBounds(216, 170, 57, 30);
        setVisible(true);
    }

    public static void main(String[] args) {
        calc2 calc = new calc2();
        calc.object();
    }
}
