import java.util.Arrays;
import javax.swing.JOptionPane;

public class arraysJOP {
    public static void main(String[] args) {
      Integer data[] = {23, 52, 86, 24, 87, 93, 23};

      JOptionPane.showMessageDialog(null, "Daftar Element : " + Arrays.toString(data));
      String input = JOptionPane.showInputDialog("Masukkan element yang ingin dicari indexnya!");
      int n = Integer.parseInt(input);

      int indexofn = Arrays.asList(data).indexOf(n);
      System.out.println("Index dari element tersebut : " + indexofn);
    }
}
