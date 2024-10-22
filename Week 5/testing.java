public class testing {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};  // Contoh array
        int sum_ganjil = 0;
        int sum_genap = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {  // Indeks ganjil
                System.out.println("Index ganjil " + i + ": " + array[i]);
                sum_ganjil += array[i];
            } else {  // Indeks genap
                System.out.println("Index genap " + i + ": " + array[i]);
                sum_genap += array[i];
            }
        }
        
        System.out.println("Total sum ganjil: " + sum_ganjil);
        System.out.println("Total sum genap: " + sum_genap);
        
    }
}
