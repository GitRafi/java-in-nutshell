import java.util.ArrayList;
import java.util.Scanner;

public class latihan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan jumlah bilangan :");
        int jumlah = scanner.nextInt();
        int[] bilangan = new int[jumlah];
        int x = 0;
        int y = 0;
        int index_genap = -1;
        int index_ganjil = -1;

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Masukkan bilangan ke-" + (i + 1) + ": ");
            bilangan[i] = scanner.nextInt();
        }

        ArrayList<Integer> ganjil = new ArrayList<>();
        ArrayList<Integer> genap = new ArrayList<>();
        ArrayList<Integer> indexarr_genap = new ArrayList<>();
        ArrayList<Integer> indexarr_ganjil = new ArrayList<>();

        for (int num : bilangan) {
            if (num % 2 == 0) {
                x++;
                index_genap++;
                indexarr_genap.add(index_genap);
                genap.add(num);
            } else {
                y++;
                index_ganjil++;
                indexarr_ganjil.add(index_ganjil);
                ganjil.add(num);
            }
        }

        System.out.println("Bilangan Genap ada " + x + " " + indexarr_genap);
        for (int num : genap) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Bilangan Ganjil ada "+ y + " " + indexarr_ganjil);
        for (int num : ganjil) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}