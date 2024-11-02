import java.util.Arrays;
public class BunchofTrash {

   static void partition(int[] arrays, int lb, int ub) {
      int pivot = arrays[lb];
      int start = lb;
      int end =ub;
      int temp=0;

      while(start < end) {
         while(arrays[start] <= pivot && start<=ub) {
         start++;
         }
      
         while(arrays[end] > pivot && end>= lb) {
         end--;
         }

         if(start < end) {
         temp = arrays[start];
         arrays[start] = arrays[end];
         arrays[end] = temp;
         }
      }
   }
   public static void main(String[] args) {
      int data[] = {7, 6, 10, 5, 6, 12, 11, 8, 2};
      partition(data, 0, (data.length-1));
      System.out.println(Arrays.toString(data));
   }
}