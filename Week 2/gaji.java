import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat; 

public class gaji {
    public static void main(String[] args) {
        //Mengambil Value Gaji
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah gaji Anda : ");
        int gaji = scanner.nextInt();
        scanner.close();

        //Menghitung potongan pajak
        float pajak = 0.1f;
        float potongan = pajak * gaji;
        float gaji_bersih = (float) (gaji - potongan);

        //Format Currency
        @SuppressWarnings("deprecation")
        NumberFormat formatrp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String gaji_bersih_format = formatrp.format(gaji_bersih);
        String potongan_format = formatrp.format(potongan);

        //Print
        System.out.println("Gaji anda terkena potongan 10% sebesar : " + potongan_format);
        System.out.println("Gaji bersih anda sebesar : " + gaji_bersih_format);
    }
}
