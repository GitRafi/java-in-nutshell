public class Sigman {

    public static int sigma(int x, int n) {
       int y = 0;
        
       while (n>0) {
        int hasil = x + (2 * n);
        y += hasil;
        n--;
       }
       return y;
    }
    public static void main(String[] args) {
        System.out.println(sigma(2, 10));
    }
}
