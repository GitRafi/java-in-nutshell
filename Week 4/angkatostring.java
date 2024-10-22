import java.util.Scanner;

public class angkatostring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih angka dari 1-10 : ");
        int angka = input.nextInt();

        if (angka == 1) {
            System.out.println("Angkamu yang kamu pilih adalah Satu");
        } else if (angka == 2) {
            System.out.println("Angkamu yang kamu pilih adalah Dua");
        } else if (angka == 3) {
            System.out.println("Angkamu yang kamu pilih adalah Tiga");
        } else if (angka == 4) {
            System.out.println("Angkamu yang kamu pilih adalah Empat");
        } else if (angka == 5) {
            System.out.println("Angkamu yang kamu pilih adalah Lima");
        } else if (angka == 6) {
            System.out.println("Angkamu yang kamu pilih adalah Enam");
        } else if (angka == 7) {
            System.out.println("Angkamu yang kamu pilih adalah Tujuh");
        } else if (angka == 8) {
            System.out.println("Angkamu yang kamu pilih adalah Delapana");
        } else if (angka == 9) {
            System.out.println("Angkamu yang kamu pilih adalah Sembilan");
        } else if (angka == 10) {
            System.out.println("Angkamu yang kamu pilih adalah Sepuluh");
        } else {
            System.out.println("Invalid Number");
        }

        input.close();
    }
}
