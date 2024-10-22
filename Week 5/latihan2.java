import javax.swing.JOptionPane;

public class latihan2 {
    public static void main(String [] args){
        int data[]={4,6,4,2,8,4,2,11};
        String input = JOptionPane.showInputDialog(null, "Masukkan nilai elemen array:");

        //mengonversi input ke integer
        int nilai = Integer.parseInt(input);

        //mencari posisi indeks nilai yang dimasukkan
        StringBuilder indeksList = new StringBuilder();
        boolean ditemukan = false;

            for (int i = 0; i < data.length; i++) {
                if (data[i] == nilai) {
                indeksList.append(i).append(" ");
                ditemukan = true;
                }
            }

        // Menampilkan hasil
        if (ditemukan) {
            JOptionPane.showMessageDialog(null, "Nilai " + nilai + " ditemukan pada indeks: " + indeksList.toString().trim());
            } else {
                JOptionPane.showMessageDialog(null, "Nilai " + nilai + " tidak ditemukan dalam array.");    
            }
    }
}