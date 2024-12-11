import java.util.Arrays;

public class Nomor3 {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 2, 7, 5, 5};
        int j = 0;
        int k = 0;
        int duplicated[] = new int[2];

        for (int i = 0; i < nums.length; i++) {

            System.out.println(nums[i]);
            if (nums[i] == k) {
            duplicated[j] = k;
            j++;
            }
            k++;

        }
        
        System.out.println(Arrays.toString(duplicated));
    }
}
