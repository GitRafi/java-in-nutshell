import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int data[] = {22, 10, 15, 3, 8, 2};

        for(int i=1;i<data.length;i++) {
            int pivot = data[i];
            int j = i-1;

            while (j >= 0 && data[j] > pivot) {
                data[j+1] = data[j];
                j = j - 1;
                System.out.println(j);
            }
            data[j+1] = pivot;
        }
        System.out.println(Arrays.toString(data));
    }    
}
