public class MoreException {
    public static void main(String[] args) {
        try {
            System.out.println(3/0);
            System.out.println("Cetak.");
        } catch (ArithmeticException ae) {
            System.out.println("Exception caught : " + ae);
        } finally {
            System.out.println("Setelah Exception");
        }
    }    
}
