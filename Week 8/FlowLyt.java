import java.awt.*;

public class FlowLyt extends Frame {

    public static void main(String[] args) {
        FlowLyt fl = new FlowLyt();
        fl.setLayout(new FlowLayout());
        fl.add(new Button("ONE"));
        fl.add(new Button("TWO"));
        fl.add(new Button("THREE"));
        fl.setSize(200, 100);
        fl.setVisible(true);
    }
}