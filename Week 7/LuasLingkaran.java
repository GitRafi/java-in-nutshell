import java.util.Scanner;

public class LuasLingkaran {
    public double luas_lingkaran (int diameter) {
        double radius = Double.valueOf(diameter) / 2;
        double luas = Math.PI * Math.pow(radius, 2);
        return luas;
    }

    public void hitungluaslingkaran (int radius) {
        double luas = Math.PI * Math.pow(radius, 2);
        System.out.println("Luas lingkaran = " + luas);
    }

    public double v_tabung (int radius, int height) {
        double volume = Math.PI * Math.pow(radius, 2) * height;
        return volume;
    }

    public double v_kerucut (int radius, int height) {
        double volume = Math.PI * Math.pow(radius, 2) * height * 1/3;
        return volume;
    }

    public double v_bola (int radius) {
        double volume = Math.PI * Math.pow(radius, 3) * 4/3;
        return volume;
    }

    public static void main (String[] args) {
        LuasLingkaran circle = new LuasLingkaran();
        System.out.println(circle.luas_lingkaran(20));
        circle.hitungluaslingkaran(10);

        Scanner sc = new Scanner(System.in);
        System.out.println("Pilih no 1-4");
        System.out.println("1. Hitung luas lingkaran");
        System.out.println("2. Hitung volume tabung");
        System.out.println("3. Hitung volume kerucut");
        System.out.println("4. Hitung volume bola");
        int input = sc.nextInt();
        
        int jari = 0;
        int height = 0;

        switch (input) {
            case (1):
            System.out.print("Masukkan jari-jari lingkaran : ");
            jari = sc.nextInt();
            circle.hitungluaslingkaran(jari);
            break;

            case (2):
            System.out.print("Masukkan jari-jari alas : ");
            jari = sc.nextInt();
            System.out.print("Masukkan tinggi tabung : ");
            height = sc.nextInt();
            System.out.print("Volume tabung = " + circle.v_tabung(jari, height));
            break;

            case (3):
            System.out.print("Masukkan jari-jari alas : ");
            jari = sc.nextInt();
            System.out.print("Masukkan tinggi kerucut : ");
            height = sc.nextInt();
            System.out.print("Volume kerucut = " + circle.v_kerucut(jari, height));
            break;

            case (4):
            System.out.print("Masukkan jari-jari bola : ");
            jari = sc.nextInt();
            System.out.print("Volume bola = " + circle.v_bola(jari));
            break;

            default:
            System.out.println("Invalid Input");
            break;
        }
        sc.close();
    }
}
