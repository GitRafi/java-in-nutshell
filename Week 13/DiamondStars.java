import java.util.Scanner;

public class DiamondStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inputkan angka positif: ");
        int a = sc.nextInt();
        assert a > 0 : "Bilangan positif kocak";

        for (int i=1;i<=a;i++) {
            for (int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
