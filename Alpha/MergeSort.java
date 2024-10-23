package Alpha;


public class MergeSort {

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
