import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class EventCalc2 extends JFrame {
    JTextField input = new JTextField();
    Font font1 = new Font("SansSerif", Font.PLAIN, 17);
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

    EventCalc2() {
        setTitle("Kalkulator Sederhana");
        setLocationRelativeTo(null);
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void event() {
        no1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "1");
            }
        });
        no2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "2");
            }
        });
        no3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "3");
            }
        });
        no4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "4");
            }
        });
        no5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "5");
            }
        });
        no6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "6");
            }
        });
        no7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "7");
            }
        });
        no8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "8");
            }
        });
        no9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "9");
            }
        });
        no0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText(input.getText() + "0");
            }
        });
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (input.getText().contains("-") || input.getText().contains("/") || input.getText().contains("*")) {
                    input.setText((input.getText().substring(0, input.getText().length() -1)) + "+");
                } else {
                input.setText(input.getText() + "+");
                }
            }
        });
        minus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (input.getText().contains("+") || input.getText().contains("/") || input.getText().contains("*")) {
                    input.setText((input.getText().substring(0, input.getText().length() - 1)) + "-");
                } else {
                input.setText(input.getText() + "-");
                }
            }
        });
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (input.getText().contains("+") || input.getText().contains("-") || input.getText().contains("*")) {
                    input.setText((input.getText().substring(0, input.getText().length() - 1)) + "/");
                } else {
                input.setText(input.getText() + "/");
                }
            }
        });
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (input.getText().contains("+") || input.getText().contains("-") || input.getText().contains("/")) {
                    input.setText((input.getText().substring(0, input.getText().length() - 1)) + "*");
                } else {
                input.setText(input.getText() + "*");
                }
            }
        });
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                input.setText("");
            }
        });
        equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String text = input.getText();
                int a = 0;
                int b = 0;
                if (text.contains("+")) {
                    StringTokenizer st = new StringTokenizer(text, "+");
                    a = Integer.valueOf(st.nextToken());
                    b = Integer.valueOf(st.nextToken());
                } else if (text.contains("-")) {
                    StringTokenizer st = new StringTokenizer(text, "-");
                    a = Integer.valueOf(st.nextToken());
                    b = Integer.valueOf(st.nextToken());
                } else if (text.contains("*")) {
                    StringTokenizer st = new StringTokenizer(text, "*");
                    a = Integer.valueOf(st.nextToken());
                    b = Integer.valueOf(st.nextToken());
                } else if (text.contains("/")) {
                    StringTokenizer st = new StringTokenizer(text, "/");
                    a = Integer.valueOf(st.nextToken());
                    b = Integer.valueOf(st.nextToken());
                } else {
                    input.setText("Invaid operator");
                }
                long hasil = 0;
                double hasil_double = 0;

                if (input.getText().contains("+")) {
                    hasil = a + b;
                    input.setText(String.valueOf(hasil));
                } else if (input.getText().contains("-")) {
                    hasil = a - b;
                    input.setText(String.valueOf(hasil));
                } else if (input.getText().contains("*")) {
                    hasil = a * b;
                    input.setText(String.valueOf(hasil));
                } else if (input.getText().contains("/")) {
                    if (b == 0) {
                        input.setText("Error: Division by 0");
                    } else {
                    hasil_double = (double) a / (double) b;
                    input.setText(String.valueOf(hasil_double));
                    }
                } else {
                    input.setText("Invalid input!");
                }

                
            }
        });

        // while (true) {
        //     System.out.println(input.getText());
        // }
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


        input.setFont(font1);
        input.setLocation(5, 5);

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
        EventCalc2 calc = new EventCalc2();
        calc.object();
        calc.event();
    }
}

