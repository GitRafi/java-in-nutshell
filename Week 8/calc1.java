import java.awt.*;

class calc1 extends Frame {

    calc1() {

    setTitle("Simple Calculator");
    setLayout(null);
    setSize(300, 280);
    Label label1 = new Label("Masukkan Angka Pertama :");
    Label label2 = new Label("Masukkan Operator :");
    Label label3 = new Label("Masukkan Angka Kedua :");
    TextField input1 = new TextField();
    TextField operator = new TextField();
    TextField input2 = new TextField();
    Button plus = new Button("+");
    Button minus = new Button("-");
    Button divide = new Button("/");
    Button multiply = new Button("*");


    //Set the size, etc XD
    label1.setBounds(75, 30, 150, 20);
    input1.setBounds(75, 50, 150, 20);
    label2.setBounds(75, 70, 150, 20);
    operator.setBounds(75, 90, 150, 20);
    label3.setBounds(75, 110, 150, 20);
    input2.setBounds(75, 130, 150, 20);
    plus.setBounds(70, 160, 50, 20);
    minus.setBounds(125, 160, 50, 20);
    divide.setBounds(180, 160, 50, 20);
    multiply.setBounds(125, 190, 50, 20);

    //Add the component
    add(label1);
    add(input1);
    add(label2);
    add(operator);
    add(label3);
    add(input2);
    add(plus);
    add(minus);
    add(divide);
    add(multiply);
    setVisible(true);
    }

    public static void main(String[] args) {
        new calc1();
    }
}