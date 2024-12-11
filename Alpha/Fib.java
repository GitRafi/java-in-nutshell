public class Fib {
    public static void main(String[] args) {
        Fibonanci(10);
        
        System.out.println();

        int N = 10;
        for (int i=0; i < N; i++) {
        System.out.print(FibonanciRecursive(i) + " ");
        }
    }

    static void Fibonanci(int N) {
        int num1 = 0, num2 = 1;

        for (int i = 0; i < N; i++) {
            System.out.print(num1 + " ");

            // Swapping
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
    }

    static int FibonanciRecursive(int n) {
        // Base case
        if (n <= 1) {
            return n;
        }

        // Recursive func
        return FibonanciRecursive(n - 1) + FibonanciRecursive(n - 2);
    }
}