import javax.swing.JOptionPane;

public class errorhandling2 {
    public static void main(String[] args) {
        String name = "";
        name = JOptionPane.showInputDialog("Masukkan nama Anda : ");
        String output = "Halo, " + name + ".Selamat datang";
        JOptionPane.showMessageDialog(null, output);
    }
}
