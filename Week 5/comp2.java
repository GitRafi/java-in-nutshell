public class comp2 {
    public static void main(String[] args) {

        int array[] = new int[50];

        int a = 0;
        for(int i=0;i<array.length;i++) {
            a += 2;
            array[i]=a;
            System.out.println(array[i]);
        }
    }
}
