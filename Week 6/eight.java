public class eight {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int[] element1 = new int[10];
        int[] element2 = {723, 849, 184, 537, 905, 8, 748, 263, 319, 483};

        for(int i=0;i<element2.length;i++) {
            if(element2[i] == 8) {
                System.out.println("Element 8 ditemukan di indeks : " + i);
            }
        }
    }
}
