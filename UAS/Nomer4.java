import java.util.Scanner;

public class Nomer4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan urutan angka fibonanci:");
        int n = scanner.nextInt();

        System.out.println(n + "th" + " Fibonanci number is: " + Fibonanci(n)); 
    }

    static int Fibonanci(int n) {
        if (n <= 1) {
            return n;
        }

        return Fibonanci(n - 1) + Fibonanci(n - 2);
    }
}
