public class Faktorial {
    public static void main(String[] args) {
        //Batas dari faktorial yang ingin dicari
        byte batas=4;
        //Long untuk menyimpan hasil Faktorial
        long faktorial=1; 
        //Faktorial dimulai dari 0, lalu increment sampai 4
        for (int i=0;i<=batas;i++) {
            faktorial=1;
            /*Menghitung faktornya, jika lebih false maka block ini tidak berjalan
            Sehingga program hanya memberikan output '1' ke variabel faktorial
            Jika faktor lebih dari atau sama dengan 2, maka block baru jalan 
            Misal jika i=3, maka faktor akan mempunyai nilai 2 dan 3, lalu akan
            dikalikan dengan value variabel faktorial yang menjadi 1x2x3 */
            for (int faktor=2;faktor<=i;faktor++) {
                faktorial*=faktor;
            }
        System.out.println(i+"!" + " = " +faktorial);
        }
    }
}
