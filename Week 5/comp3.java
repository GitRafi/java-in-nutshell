import java.util.ArrayList;
import java.util.Scanner;

public class comp3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan berapa banyak element array : ");
        int arr = input.nextInt();

        int array[] = new int[arr];
        ArrayList<Integer> genaparr = new ArrayList<>();
        int x=0;
        for(int i=0;i<arr;i++) {
            System.out.println("Masukkan element ke-" + (i+1));
            array[i] = input.nextInt();
            if (array[i] % 2 == 0) {
                genaparr.add(i);
                x++;
            }
        }
        System.out.println("Ada bilangan genap sebanyak " + x + " di " + genaparr);
        input.close();
    }
}

