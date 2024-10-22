import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class tugas3 {

    public static void main(String[] args) {
        //Tugas 1 : Mengambil user input untuk 3 bilangan
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String bil1 = "";
        String bil2 = "";
        String bil3 = "";

        System.out.print("Masukkan bilangan A : ");
        try {
            bil1 = input.readLine();
        } catch (IOException e) {
            System.out.println("Error");
        }

        System.out.print("Masukkan bilangan B : ");
        try {
            bil2 = input.readLine();
        } catch (IOException e) {
            System.out.println("Error");
        }

        System.out.print("Masukkan bilangan C : ");
        try {
            bil3 = input.readLine();
        } catch (IOException e) {
            System.out.println("Error");
        }

        //Konversi String to Int
        int no1 = Integer.parseInt(bil1);
        int no2 = Integer.parseInt(bil2);
        int no3 = Integer.parseInt(bil3);

        //Tugas 2
        //Masukkan int ke Array
        Integer [] array = {no1 , no2, no3};
        Arrays.sort(array);

        //Format array supaya bracket hilang saat diprint
        String formatarray = Arrays.toString(array)
            .replace("[", "")
            .replace("]" , "");

        System.out.println("Bilangan diurutkan dengan Ascending : " + formatarray);

        //Tugas 3 : Menjumlahkan 2 bilangan dengan JOptionPane
        String pilihan = JOptionPane.showInputDialog(null, "ketik operasi yang diinginkan, 1 untuk A+B, 2 untuk A+C, 3 untuk B+C");
        int pilihan_user = Integer.parseInt(pilihan);
        int total;

        if (pilihan_user == 1) {
            total = no1 + no2;
        } else if (pilihan_user == 2) {
            total = no1 + no3;
        } else {
            total = no2 + no3;
        }
        
        JOptionPane.showMessageDialog(null, "Hasil penjumlahan : " + total);

    }
}