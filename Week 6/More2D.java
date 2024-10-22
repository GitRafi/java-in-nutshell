import java.util.Arrays;
import javax.swing.JOptionPane;

public class More2D {
    public static void main(String[] args) {
        int[][] data={{4,6,4,2,8,4,2,10}, {4,6,4,2,8,4,2,10}};
        System.out.println("Jumlah baris = " + data.length);
        System.out.println("Jumlah kolom = " + data[0].length);
        System.out.println();

        int sum=0;
        for(int i=0;i<data.length;i++) {
            for(int j=0;j<data[0].length;j++) {
                System.out.print(data[i][j] + " ");
                sum += data[i][j];
            }
            System.out.println();
        }
        float denom = data[0].length * data.length;
        float total = Float.valueOf(sum);
        float mean = total/denom;
        System.out.println("Total penjumlahan semua element : " + total + ", rata-rata : " + mean);
   
        int find = Integer.parseInt(JOptionPane.showInputDialog("Masukkan element yang ingin diganti!"));
        int replace = Integer.parseInt(JOptionPane.showInputDialog("Masukkan value pengganti!"));
        for(int a=0;a<data.length;a++) {
            for(int b=0;b<data[0].length;b++){
                if (find == data[a][b]) {
                    data[a][b] = replace;
                }
            }
        }
        System.out.println("Array setelah dirubah : " + Arrays.deepToString(data)); 

        //Add column odd 
        int odd=0; 
        for(int i=0;i<data.length;i++) {
            for(int j=1;j<data[0].length;j+=2) {
                odd += data[i][j];
            }
        }
        System.out.println("Hasil penjumlahan setiap element index ganjil : " + odd);

        //Add column even
        int even=0;
        for(int i=0;i<data.length;i++) {
            for(int j=0;j<data[0].length;j+=2) {
                even += data[i][j];
            }
        }
        System.out.println("Hasil penjumlahan setiap element index genap : " + even);
    }
}
