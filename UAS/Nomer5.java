import java.util.Scanner;

public class Nomer5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Anda ingin mencari index element apa > ");
        int n = scanner.nextInt();
        
        int someNumber[] = {5, 2, 1, 6, 3, 5};
        for (int i = 0; i < someNumber.length; i++) {
            if (someNumber[i] == n) {
                System.out.println("Element " + n + " ditemukan pada index ke-" + (i));
            }
        }
        
    }
}
