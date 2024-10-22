import javax.swing.JOptionPane;
import java.util.Arrays;

public class arraysum {
    public static void main(String[] args) {
        int data[] = new int[10];
        int maxIndex = 0;
        int minIndex = 0;
        for(int i=0;i<data.length;i++) {
            data[i]=Integer.parseInt(JOptionPane.showInputDialog("Masukkan element index ke-" + i));
            System.out.println(data[i]);

            //Cari value max
            if(data[i] > data[maxIndex]) {
                maxIndex = i;
            }
            
            //Cari value min
            if(data[i] < data[minIndex]) {
                minIndex = i;
            }
        }

        //Tambahkan semua element
        int sum=0;
        for(int i=0;i<data.length;i++) {
            sum += data[i];
        }
        //Rata-rata
        float mean = sum / data.length;

        System.out.println("Element terbesar : " + data[maxIndex] + " pada index ke-" + maxIndex);
        System.out.println("Element terkecil : " + data[minIndex] + " pada index ke-" + minIndex);
        System.out.println("Rata-rata : " + mean);

        //Mencari posisi index
        int x = Integer.parseInt(JOptionPane.showInputDialog("Masukkan element yang ingin dicari Indexnya!"));
   
        StringBuilder indeks = new StringBuilder();
        boolean find = false;

        for(int i=0;i<data.length;i++){
            if(data[i] == x) {
                indeks.append(i).append(" ");
                find = true;

                if(find) {
                    JOptionPane.showMessageDialog(null, "Element " + x + " ditemukan pada indeks " + indeks.toString().trim());
                } else {
                    JOptionPane.showMessageDialog(null, "Element tidak ditemukan");
                }

                String confirm = JOptionPane.showInputDialog("Apakah kamu ingin mengganti value elementnya? (Y/N)");
                if(confirm.equals("Y")) {
                    data[i] = Integer.parseInt(JOptionPane.showInputDialog("Masukkan element baru!"));
                    System.out.println("Hasil akhir array : " + Arrays.toString(data));
                } else {
                    JOptionPane.showMessageDialog(null, "Program selesai");
                }
            }
        }
    }
}