import java.util.Arrays;
import java.util.Scanner;

public class comp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan berapa banyak element array : ");
        int arr = input.nextInt();

        int array[] = new int[arr];
        
        for(int i=0;i<arr;i++) {
            System.out.println("Masukkan element ke-" + (i+1));
            array[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(array));

        for (int i=0;i<array.length;i++) {
            if(array[i] % 2 == 0) {
                System.out.println("Angka " + array[i] + " adalah bilangan" + " genap");
            } else {
                System.out.println("Angka " + array[i] + " adalah bilangan" + " ganjil");
            }
        }
        input.close();
    }
}
