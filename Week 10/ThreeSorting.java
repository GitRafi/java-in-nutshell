import java.util.Arrays;
import java.util.Scanner;

class quicksort {

    private int partition(int[] arrays, int start, int end) { //params are arrays, lower bound(start), upper bound (end)
        int pivot = arrays[end];
        int i = (start - 1);
        for (int j=start;j<=end;j++) {
            if(arrays[j] < pivot) {
                i++;
                int t = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = t;
            }
        }
        i++;
        int t = arrays[i];
        arrays[i] = arrays[end];
        arrays[end] = t;
        return i;
    }

    public void quickSort(int[] arrays, int start, int end) {
        if (end <= start) return; //base condition, will the stop recursion if arrays has 1 or no element
        int pivot = partition(arrays, start, end);
        quickSort(arrays, start, pivot-1);
        quickSort(arrays, pivot+1, end);
    }
}

class MergeSort {

    public static void mergeSort(int[] inputArray) {
        int length = inputArray.length;

        if(length <= 1) return; //base to stop the recursion

        int median = length / 2; //find the midle part
        int[] leftHalf = new int[median];
        int[] rightHalf = new int[length - median];

        for (int i=0;i<median;i++) { //put element in original array to lefthalf
            leftHalf[i] = inputArray[i];
        }

        for (int i=median;i<length;i++) { //put element in original array to righthalf 
            rightHalf[i - median] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);
    }

    public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;

        int i=0, j=0, k=0; // So, the i is for left then j for right, and lastly k for the merge array

        while (i < leftLength && j < rightLength) { // Start the sorting comparing left & right side element
            if (leftHalf[i] <= rightHalf[i]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}

public class ThreeSorting {

    public static void bublesort(int[] arrays) {
        int n = arrays.length;
        int temp = 0; //temp for swapping vars
        for (int i=0;i<n;i++) {
            for (int j=1;j<(n-i);j++) {
                if (arrays[j-1] > arrays[j]) {
                    temp = arrays[j-1];
                    arrays[j-1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        quicksort QuickSort = new quicksort();
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah element: ");
        int total = sc.nextInt();

        int[] array = new int[total];

        for (int i=0;i<total;i++) {
            System.out.print("Masukkan element ke-" + (i+1) + ":");
            array[i] = sc.nextInt();
        }

        //Sorting 
        System.out.println("Pilihan Algoritma Sorting :");
        System.out.println("1. Bubble sort");
        System.out.println("2. Quick sort");
        System.out.println("3. Merge sort");
        System.out.print("pilihan :");
        int pilihan = sc.nextInt();

        sc.close();

        switch (pilihan) {
            case 1:
                long startTime1 = System.nanoTime();
                bublesort(array);
                long stopTime1 = System.nanoTime();
                System.out.println(Arrays.toString(array));
                System.out.println("Total exec time : " + (stopTime1 - startTime1) + " Nanosecond");
                break;
            case 2:
                long startTime2 = System.nanoTime();
                QuickSort.quickSort(array, 0, array.length-1);
                long stopTime2 = System.nanoTime();
                System.out.println(Arrays.toString(array));
                System.out.println("Total exec time : " + (stopTime2 - startTime2) + " Nanosecond");
            case 3:
                long startTime3 = System.nanoTime();
                MergeSort.mergeSort(array);
                long stopTime3 = System.nanoTime();
                System.out.println(Arrays.toString(array));
                System.out.println("Total exec time : " + (stopTime3 - startTime3 + " Nanosecond"));
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}