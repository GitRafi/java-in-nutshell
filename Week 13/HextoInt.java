import java.util.Scanner;

public class HextoInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Masukkan angka heksadesimal: ");
            String hex = sc.nextLine();
            Integer.parseInt(hex, 16);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input bang");
        }
        sc.close();
    }    
}
