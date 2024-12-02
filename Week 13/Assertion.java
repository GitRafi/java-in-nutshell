public class Assertion {
    public static void main(String[] args) {
        int beratBadan = Integer.parseInt(args[0]);
        assert beratBadan > 30 : "Busung lapar";
        System.out.println("Berat Badan: " + beratBadan);
    }
}
