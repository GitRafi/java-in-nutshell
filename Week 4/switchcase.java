import java.util.Scanner;
public class switchcase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih angka dari 1-10 : ");
        int angka = input.nextInt();

        switch (angka) {
            case 1:
                System.out.println("Angkamu yang kamu pilih adalah Satu");
                break;
            case 2:
                System.out.println("Angkamu yang kamu pilih adalah Dua");
                break;
            case 3:
                System.out.println("Angkamu yang kamu pilih adalah Tiga");
                break;
            case 4:
                System.out.println("Angkamu yang kamu pilih adalah Empat");
                break;
            case 5:
                System.out.println("Angkamu yang kamu pilih adalah Lima");
                break;
            case 6:
                System.out.println("Angkamu yang kamu pilih adalah Enam");
                break;
            case 7:
                System.out.println("Angkamu yang kamu pilih adalah Tujuh");
                break;
            case 8:
                System.out.println("Angkamu yang kamu pilih adalah Delapan");
                break;
            case 9:
                System.out.println("Angkamu yang kamu pilih adalah Sembilan");
                break;
            case 10:
                System.out.println("Angkamu yang kamu pilih adalah Sepuluh");
                break;
            default:
                System.out.println("Invalid Number");
                break;
        }
        input.close();
    }
}
