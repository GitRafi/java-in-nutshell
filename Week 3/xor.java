public class xor {
    public static void main(String[] args) {
          int a = 10;
          int b = 20;

        // Swap a dan b memakai XOR
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("Hasil swapping, a = " + a + " and b = " + b);

    }
}
