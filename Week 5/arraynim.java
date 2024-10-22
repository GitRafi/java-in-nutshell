import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Arrays;

public class arraynim {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih apakah NIM anda ganjil/genap! (1/2)");
        System.out.println("1. Ganjil");
        System.out.println("2. Genap");
        int choice = input.nextInt();

        int x;
        int sum = 0;
        int sum_ganjil = 0;
        int sum_genap = 0;
        int maxIndex = 0;
        int minIndex = 0;
        if(choice == 1) {
            System.out.print("Masukkan jumlah element yang diinginkan : ");
            x = input.nextInt();
        } else {
            x = Integer.parseInt(JOptionPane.showInputDialog("Masukkan jumlah element yang diinginkan!"));
        }

        int[] array = new int[x];

        if(choice == 1) {
            for(int i=0;i<array.length;i++) {
                System.out.print("Masukkan element index ke-" + i + " : ");
                array[i] = input.nextInt();
            }
        } else {
            for(int i=0;i<array.length;i++) {
                array[i] = Integer.parseInt(JOptionPane.showInputDialog("Masukkan element index ke-" + i + "!"));

                //Sekalian buat cari max and min
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }

                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
        }
        //Rata-rata dan jumlahan index genap/ganjil
        for(int i=0;i<array.length;i++) {
            if (i % 2 == 1) {
                sum_ganjil += array[i];
            } else if (i % 2 == 0 && i>0) {
                sum_genap += array[i];
            }
            sum += array[i];
        }

        float jumlah_element = Float.valueOf(array.length);
        float mean = sum / jumlah_element;
        System.out.println("Rata-rata = " + sum + ":" + array.length + " = " + mean);
        System.out.println("Hasil penjumlahan index ganjil = " + sum_ganjil); 
        System.out.println("Hasil penjumlahan index genap = " + sum_genap); 

        if (sum_ganjil % 2 == 1 && sum_genap % 2 == 1) {
            System.out.println("Hasil penjumlahan adalah ganjil");
        } else if (sum_ganjil % 2 == 0 && sum_genap % 2 == 0) {
            System.out.println("Hasil penjumlahan adalah genap");
        } else {
            System.out.println("beda (genap dan ganjil / ganjil dan genap)");
        }

        Arrays.sort(array);
        System.out.println("Element setelah diurutkan : " + Arrays.toString(array));
        input.close();
    }
}
