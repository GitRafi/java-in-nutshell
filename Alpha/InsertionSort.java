import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {42, 21, 53, 213, 124, 35, 23, 20, 359};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] array) {
        for (int i=1;i<array.length;i++) {
            int tempVar = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > tempVar) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = tempVar;
        }
    }
}
