public class ImThrowing {
    public static void main(String[] args) {
        String input = "A";
        try {
            if (input.equals(input)) {
                throw new RuntimeException("Throwing errors");
            } else {
                System.out.println(input);
            }
        System.out.println("After Throwing");
        } catch (RuntimeException re) {
            System.out.println("Something in the way");
            System.out.println(re);
        }
    }
}
