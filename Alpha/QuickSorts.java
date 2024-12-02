import java.util.Arrays;

public class QuickSorts {
    //Greater or equal to pivot, ignore it
    static void quicksort(int array[], int start, int end) {
        if (end <= start) return;
        int pivot = partition(array, start, end);
        quicksort(array, start, pivot-1);
        quicksort(array, pivot+1, end);
    
    }

    static int partition(int array[], int start, int end) {

        int pivot = array[end];
        int i = start - 1;

        for (int j=start; j<=end-1;j++) {
            if(array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;
        return i;
    }

    public static void main(String[] args) {
        int data[] = {12, 2, 5, 1, 9, 0, 15, 3};
        quicksort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }
}
