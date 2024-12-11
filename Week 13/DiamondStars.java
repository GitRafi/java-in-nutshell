import java.util.Scanner;

public class DiamondStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inputkan angka positif: ");
        int n = sc.nextInt();
        String space = " ";
        // int y = 0;
        // int m = 1;
        // int l = n * 2 - 1;
        assert n > 0 : "Bilangan positif bang -_-";
        
        int x = n-1, y = 0, m = 1, l = n * 2 - 1;
        
        for (int i=1;i<=n;i++) {
            System.out.print(space.repeat(x-y));
            for (int j=0;j<m;j++) {
                System.out.print("*");
            }
            System.out.println();
            m+=2;
            y++;
        }
        for (int i=1;i<n;i++) {
            System.out.print(space.repeat(i));
            for (int j=1;j<=(l-2);j++) {
                System.out.print("*");
            }
            System.out.println();
            l-=2;
        }
        sc.close();
    }
}
