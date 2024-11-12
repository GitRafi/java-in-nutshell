public class MultipleCatch {
    public static void main(String[] args) {
        try {
            int den = Integer.parseInt(args[0]);
            System.out.println(3/den);
        } catch (ArithmeticException ae) {
            System.out.println("Error, can't divide by 0");
        } catch (ArrayIndexOutOfBoundsException abe) {
            System.out.println("Missing argument when running program");
        }
        System.out.println("After Exception");
    }
}
