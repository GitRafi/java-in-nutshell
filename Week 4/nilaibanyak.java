import java.util.Scanner;

public class nilaibanyak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nilai = new int[11];
        String[] grade = new String[11];
        int maxIndex = 0;
        int minIndex = 0;

        //input
        for (int i = 1; i <= 10; i++) {
            System.out.print("Masukkan nilai mahasiswa ke-" + (i) + " : ");
            nilai[i] = input.nextInt();

            //Menentukan grade
            if (nilai[i] >= 86 && nilai[i] <= 100) {
                grade[i] = "A";
            } else if (nilai[i] >= 76 && nilai[i] <= 85) {
                grade[i] = "B+";
            } else if (nilai[i] >= 66 && nilai[i] <= 75) {
                grade[i] = "B";
            } else if (nilai[i] >= 56 && nilai[i] <= 65) {
                grade[i] = "C+";
            } else if (nilai[i] >= 46 && nilai[i] <= 55) {
                grade[i] = "C";
            } else if (nilai[i] >= 36 && nilai[i] <= 45) {
                grade[i] = "D";
            } else {
                grade[i] = "E"; // Nilai di bawah 36 otomatis E
            }

            //Lowest and Highest grade
            if (nilai[i] > nilai[maxIndex]) {
                maxIndex = i;
            }

            if (nilai[i] < nilai[minIndex]) {
                minIndex = i;
            }
        }

        // Menampilkan hasil
        System.out.println("\nHasil Penilaian:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Mahasiswa ke-" + (i) + " dengan nilai: " + nilai[i] + " mendapat grade: " + grade[i]);
        }
        
        int min = nilai[0];
        for (int i = 1; i<nilai.length;i++) {
            if (nilai[i] < min) {
                min = nilai[i];
            }
        }
        System.out.println("\nMahasiswa dengan nilai tertinggi adalah Mahasiswa ke-" + (maxIndex + 1) + " dengan nilai " + nilai[maxIndex]);
        System.out.println("Mahasiswa dengan nilai terendah adalah Mahasiswa ke-" + (minIndex + 1) + " dengan nilai " + min);
        input.close();  
    }
}
