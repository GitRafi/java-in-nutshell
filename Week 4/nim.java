import java.util.Scanner;
import javax.swing.JOptionPane;

public class nim {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan NIM Mahasiswa : ");
        long nim = input.nextLong();
        long digit, sum=0;
        long mods = nim % 2;
        long nim2=nim;

        if (mods == 1) {
            System.out.println("NIM ganjil");
            String a=JOptionPane.showInputDialog("Masukkan kembali NIM anda");
            long nim_ganjil = Long.parseLong(a);
            System.out.println("NIM anda : " + nim_ganjil);
        } else {
            System.out.println("NIM genap");
            System.out.print("Masukkan NIM kembali : ");
            long nim_genap = input.nextLong();
            System.out.println("NIM anda : " + nim_genap);
        }

        while (nim>0) {
            digit = nim % 10;
            sum = sum + digit;
            nim = nim/10;
        }
        System.out.println("Jumlah semua digit dalam NIM " + nim2 + " = " + sum);
        input.close();
    }
}
