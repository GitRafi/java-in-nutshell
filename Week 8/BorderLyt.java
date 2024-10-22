import java.awt.*;
public class BorderLyt extends Frame {
    public static void main(String[] args) {
        BorderLyt bl = new BorderLyt();
        bl.setLayout(new BorderLayout(10,10));
        bl.add(new Button("NORTH"), BorderLayout.NORTH);
        bl.add(new Button("SOUTH"), BorderLayout.SOUTH);
        bl.add(new Button("EAST"), BorderLayout.EAST);
        bl.add(new Button("WEST"), BorderLayout.WEST);
        bl.add(new Button("CENTER"), BorderLayout.CENTER);
        bl.setSize(200, 200);
        bl.setVisible(true);
    }
}
