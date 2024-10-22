import java.util.Scanner;

public class lingkaran {
    public static void main(String[] args) {
        float pi = 3.14f;
        Scanner input = new Scanner(System.in);

        System.out.println("Masukan jari-jari : ");
        float r = input.nextFloat();

        float luas = pi * r * r;

        System.out.println("Luas Lingkaran : " + luas);
        input.close();
    }
}
