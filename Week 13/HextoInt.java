import java.util.Scanner;

public class HextoInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Masukkan angka heksadesimal: ");
            String hex = sc.nextLine();
            if (!hex.matches("[0-9A-Fa-f]+")) {
                throw new MyException("Invalid input bang, hex 0-9 A-F");
            }
            Integer.parseInt(hex, 16);
        } catch (MyException e) {
            System.out.println("Look like we got an exception");
            System.err.println(e.getMessage());
        } finally {
        sc.close();
        }
    }    
}

class MyException extends NumberFormatException {
    public MyException(String string) {
        super(string);
    }
}
