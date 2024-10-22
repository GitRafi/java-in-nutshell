public class perulanganfor {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        for (int i=1; i<=10; i++) {
            System.out.println(i);
        }

        for (int i=1; i<=10; i++) {
            result.append(i).append(",");
        }
        result.setLength(result.length() - 1);
        System.out.print(result);
    }
}
