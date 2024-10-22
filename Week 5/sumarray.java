public class sumarray {
    public static void main(String[] args) {
        float data[] = {4,2,1,5,2,6,8,3,5,2};
        float j = 0f;
        float sum = 0f;
        for(int i=0;i<data.length;i++) {
            j += data[i];
            sum = j / data.length;
        }
        System.out.println(sum);
    }
}
