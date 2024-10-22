public class perulanganwhile {
    public static void main(String[] args) {
        StringBuilder hasil = new StringBuilder();
        int i = 10;
        int o = 10;
        while (i<=20) {
            System.out.println(i);
            i++;
        }

        while (o<=20) {
            hasil.append(o).append(",");
            o++;
        }
        hasil.setLength(hasil.length() - 1);
        System.out.print(hasil);
    }
}
