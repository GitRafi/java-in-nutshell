import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EventCalc extends JFrame {
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    JTextField operand1 = new JTextField();
    JTextField operator = new JTextField();
    JTextField operand2 = new JTextField();
    JTextField hasil = new JTextField();
    JLabel label1 = new JLabel("Masukkan angka pertama");
    JLabel label_operator = new JLabel("Masukkan operator");
    JLabel label2 = new JLabel("Masukkan angka kedua");
    JLabel label_hasil = new JLabel("Hasil");
    Button add = new Button("+");
    Button min = new Button("-");
    Button divide = new Button("/");
    Button multiply = new Button("*");
    Button equal = new Button("=");

    EventCalc() {
        setTitle("Calculator");
        setLocationRelativeTo(null);
        setSize(300, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(label1);
        getContentPane().add(label_operator);
        getContentPane().add(label2);
        getContentPane().add(operand1);
        getContentPane().add(operator);
        getContentPane().add(operand2);
        getContentPane().add(label_hasil);
        getContentPane().add(hasil);
        getContentPane().add(add);
        getContentPane().add(min);
        getContentPane().add(divide);
        getContentPane().add(multiply);
        getContentPane().add(equal);

        //Set position
        label1.setBounds(72, 20, 150, 20);
        operand1.setBounds(70, 50, 150, 32);
        label_operator.setBounds(87, 85, 150, 20);
        operator.setBounds(70, 110, 150, 32 );
        label2.setBounds(80, 145, 150, 20);
        operand2.setBounds(70, 170, 150, 32);
        label_hasil.setBounds(130, 205, 150, 20);
        hasil.setBounds(70, 230, 150, 32);;
        add.setBounds(50, 270, 50, 25 );
        min.setBounds(120, 270, 50, 25 );
        divide.setBounds(190, 270, 50, 25 );
        multiply.setBounds(80, 310, 50, 25 );
        equal.setBounds(160, 310, 50, 25);
        
    }

    void key_listener() {
        add.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent press) {
                operator.setText("+");
            }
        });

        min.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent press) {
                operator.setText("-");
            }
        });

        divide.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent press) {
                operator.setText("/");
            }
        });
        
        multiply.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent press) {
                operator.setText("*");
            }
        });

        equal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent press) {
                int a = Integer.parseInt(operand1.getText());
                int b = Integer.parseInt(operand2.getText());
                String op = operator.getText();
                int result = 0;
                double result_float = 0;

                switch (op) {
                    case "+":
                        result = a + b;
                        hasil.setText(String.valueOf(result));
                        break;
                    
                    case "-":
                        result = a - b;
                        hasil.setText(String.valueOf(result));
                        break;
                    
                    case "/":
                        if (b == 0) {
                            hasil.setText("Error : Division by zero");
                            break;
                        }
                        double x = Double.valueOf(a);
                        double y = Double.valueOf(b);
                        result_float = x / y;
                        hasil.setText(String.valueOf(result_float));
                        break;
                    
                    case "*":
                        result = a * b;
                        hasil.setText(String.valueOf(result));
                        break;
                
                    default:
                        hasil.setText("Error : Invalid Operator");
                        break;
                }

            }
        });

    }

    public static void main(String[] args) {
        EventCalc calc = new EventCalc();
        calc.object();
        calc.key_listener();
    }
}