import java.util.Arrays;

import javax.swing.JOptionPane;

public class TwoMatrix {
    public static void main(String[] args) {
        int[][] data1 = {{1, 2, 9}, {2, 1, 5}};
        int[][] data2 = {{5, 1, 7}, {10, 4, 9}};
        int[][] total = new int[2][3];

        int input = Integer.parseInt(JOptionPane.showInputDialog("Masukkan angka yang ingin dicari indexnya!"));

        for (int i=0;i<data1.length;i++) {
            for (int j=0;j<data1[0].length;j++) {
                if (input == data1[i][j]) {
                    System.out.println("Element " + input + " ditemukan pada baris " + (i+1) + " kolom " + (j+1));
                }
            }
        }

        for (int i=0;i<data1.length;i++) {
            for (int j=0;j<data1[0].length;j++) {
                total[i][j] = data1[i][j] + data2[i][j];
            }
        }

        System.out.println("Hasil array setelah dijumlahkan : " + Arrays.deepToString(total));

    }
}