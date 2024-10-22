import java.util.Scanner;
public class ExceptionStr {
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Masukkan NIM anda : ");
            long nim = input.nextLong();
            System.out.println("Berhasil absen " + nim);
        } catch (Exception e) {
            System.out.print("Invalid Input, only number are accepted");
        } finally {
            input.close();
        }
   } 
}
