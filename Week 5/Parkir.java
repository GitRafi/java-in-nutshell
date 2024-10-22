import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Parkir {

    static int totalTempat = 10;
    static int tempatFree = 10;
    static ArrayList<String> daftar_kendaraan = new ArrayList<>();
    public static void main(String[] args) {

        while (true) {
            int input = Integer.parseInt(JOptionPane.showInputDialog("Silahkan pilih opsi dibawah ini\n" + "1. Memarkir kendaraan\n"
            + "2. Menghapus daftar parkiran\n" + "3. Melihat daftar kendaraan\n" + "4. Exit"));

            switch (input) {
                case 1:
                    parkirKendaraan();
                    break;
                case 2:
                    hapusKendaraan();
                    break; 
                case 3:
                    lihatKendaraan();
                    break;
                case 4:
                    System.exit(0);
                    break;
            
                default:
                    JOptionPane.showMessageDialog(null, "Selamat tinggal");
                    break;
            }
        }
    }

    public static void parkirKendaraan() {
        if (tempatFree == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, parkiran sudah penuh");
            return;
        }

        String plat = JOptionPane.showInputDialog("Masukkan nomor plat kendaraan");
        daftar_kendaraan.add(plat);
        tempatFree--;
        JOptionPane.showMessageDialog(null, "Berhasil di parkirkan, sisa tempat parkir : " + tempatFree);
    }

    public static void hapusKendaraan() {
        if (totalTempat == tempatFree) {
            JOptionPane.showMessageDialog(null, "Tempat parkir kosong, tidak bisa menghapus");
        }

        String plat = JOptionPane.showInputDialog("Masukkan plat kendaraan yang ingin dihapus");
        if (daftar_kendaraan.contains(plat)) {
            daftar_kendaraan.remove(plat);
            tempatFree++;
            JOptionPane.showMessageDialog(null, "Kendaraan berhasil dihapus, sisa tempat parkir : " + tempatFree);
        } else {
            JOptionPane.showMessageDialog(null, "Maaf, kendaraan tidak terdapat dalam daftar parkir");
        }
    }

    public static void lihatKendaraan() {
        if (totalTempat == tempatFree) {
            JOptionPane.showMessageDialog(null, "Tidak ada kendaraan, tempat parkir kosong");
        }

        JOptionPane.showMessageDialog(null, "Daftar plat kendaraan : " + daftar_kendaraan.toString() + "\nSisa tempat parkir : " + tempatFree);

    }
}
