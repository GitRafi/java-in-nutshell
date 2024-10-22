import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class errorhandling {
    public static void main(String[] args) {
        BufferedReader datain = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        String NIM = "";

        System.out.print("Silahkan masukkan nama Anda : ");
        try {
            name = datain.readLine();
        } catch (IOException e) {
            System.out.println("Error");
        }

        System.out.print("Silahkan masukkan NIM Anda : ");
        try {
            NIM = datain.readLine();
        } catch (IOException e) {
            System.out.println("Error");
        }
        System.out.println("Bonjour " + name + ", Anda berhasil membuatnya!");
        System.out.println("NIM Anda : " + NIM + ", Anda berhasil absen.");
    }
}
