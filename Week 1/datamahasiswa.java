import java.util.Scanner;

public class datamahasiswa{
    public static void main(String[] args) {
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama Mahasiswa: ");
        String nama = scanner.nextLine();
        // Meminta pengguna untuk memasukan nomor mahasiswa
        System.out.print("Masukan nomer Mahasiswa: ");
        String nomorMahasiswa = scanner.nextLine();
        // Menampilkan hasil input dari user
        System.out.println("Data Mahasiswa:");
        System.out.println("Nama: " + nama);
        System.out.println("Nomor Mahasiswa: " + nomorMahasiswa);

        // Tutup scanner
        scanner.close();
    }
}