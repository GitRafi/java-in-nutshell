import java.util.Scanner;

public class inputnilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama          : ");
        String nama = input.nextLine();
        System.out.print("Jumlah nilai  : ");
        int total_nilai = input.nextInt();
        int nilai[] = new int[total_nilai];
        
        for (int i=0;i<total_nilai;i++) {
            System.out.print("Nilai " + (i+1) + "       : ");
            nilai[i] = input.nextInt();
        }

        int sum = 0;
        for(int i=0;i<nilai.length;i++){
            sum += nilai[i];
        }

        float sum_float = Float.valueOf(sum);
        float banyak_nilai = Float.valueOf(nilai.length);
        float mean = sum_float / banyak_nilai;
        System.out.println(nama + "," + " nilai rata-rata adalah " + mean + ".");
        input.close();
    }
}
