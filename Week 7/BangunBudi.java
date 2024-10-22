import javax.swing.JOptionPane;

public class BangunBudi {
    public static int kubus (int s) {
        return s * s * s;
    }
    
    public static int balok (int p, int l, int t) {
        return p * l * t;
    }

    public static double tabung (int radius, int t) {
        double alas = Math.PI * radius * radius;
        double volume = alas * t;
        return volume;
        }

    public static void main(String[] args) {
        int input = Integer.parseInt(JOptionPane.showInputDialog("Hitung volume\n" + "1.Kubus\n" + "2.Balok\n" + "3.Tabung"));

        switch (input) {
            case 1:
                int s = Integer.parseInt(JOptionPane.showInputDialog("Berapa ukuran sisi kubus?"));
                JOptionPane.showMessageDialog(null, "Volume kubus = " + kubus(s));
                break;

            case 2:
                int p = Integer.parseInt(JOptionPane.showInputDialog("Berapa ukuran panjang balok?"));
                int l = Integer.parseInt(JOptionPane.showInputDialog("Berapa ukuran lebar balok?"));
                int t = Integer.parseInt(JOptionPane.showInputDialog("Berapa ukuran tinggi balok?"));
                JOptionPane.showMessageDialog(null, "Volume balok = " + balok(p, l, t));
                break;

            case 3:
                int radius = Integer.parseInt(JOptionPane.showInputDialog("Masukkar jari-jari alas!"));
                int tinggi = Integer.parseInt(JOptionPane.showInputDialog("Masukkar tinggi tabung!"));
                JOptionPane.showMessageDialog(null, "Volume tabung = " + tabung(radius, tinggi));

            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
