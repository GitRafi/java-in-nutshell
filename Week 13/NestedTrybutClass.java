public class NestedTrybutClass {
    static void nestedTry(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            System.out.println("Error, can't divide by 0");
        }
    }

    public static void main(String[] args) {
        try {
            nestedTry(args);
        } catch (ArrayIndexOutOfBoundsException abe) {
            System.out.println("Missing argument, this program require 2 argument");
        }
    }
}