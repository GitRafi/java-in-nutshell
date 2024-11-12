public class NestedTry {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            try {
                int b = Integer.parseInt(args[1]);
                System.out.println(a/b);
            } catch (ArithmeticException ae) {
                System.out.println("Error, can't divide by 0");
            } 
        } catch (ArrayIndexOutOfBoundsException abe) {
            System.out.println("Missing argument, this program require 2 argument");
        }
    }
}
