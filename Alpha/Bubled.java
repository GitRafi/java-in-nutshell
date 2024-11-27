import java.util.Arrays;
import java.util.Random;

public class Bubled {
    public static void main(String[] args) {
        int[] array = new int[10];

        for(int i=0;i<array.length;i++) {
            Random rand = new Random();
            array[i] = rand.nextInt(10000);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));
        bubleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static void bubleSort(int[] array) {
        boolean itsSwapped = true;

        while (itsSwapped) {
            itsSwapped = false;
            for (int i=0; i < array.length - 1; i++) {
                    if (array[i] > array[i+1]) {
                        itsSwapped = true;
                        int tempVar = array[i];
                        array[i] = array[i+1];
                        array[i+1] = tempVar; 
                    }
                }   
            }
        }
    
}
