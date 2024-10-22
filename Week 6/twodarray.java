public class twodarray {
    public static void main(String[] args) {
        int baris, kolom;
        int[][] bil = {
            {1,2,35,7,10},
            {6,7,4,1,0}
        };

        for (baris = 0; baris < 2; baris++){
            for(kolom = 0; kolom < 5; kolom++) {
                System.out.println("Element indeks ke [" + baris + "," + kolom + "]" + " " + bil[baris][kolom]);
            }
        }
    }
}
