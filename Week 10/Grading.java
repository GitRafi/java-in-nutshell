import javax.swing.*;
import java.sql.*;

public class Grading extends JFrame {
    JLabel nim = new JLabel("NIM");
    JLabel nama = new JLabel("Nama");
    JLabel kelas = new JLabel("Kelas");
    JLabel matkul = new JLabel("Mata Kuliah");
    JLabel kelas_a = new JLabel("A");
    JLabel kelas_b = new JLabel("B");
    JLabel kelas_c = new JLabel("C");
    JTextArea input_nim = new JTextArea();
    JTextArea input_nama = new JTextArea();
    JRadioButton a = new JRadioButton();
    JRadioButton b = new JRadioButton();
    JRadioButton c = new JRadioButton();
    JButton search = new JButton("Cari");
    JButton edit = new JButton("Edit");
    JButton simpan = new JButton("Simpan");
    JButton hapus = new JButton("Hapus");
    JButton keluar = new JButton("Keluar");
    String[] lorem = {"Kalkulus", "Pemrograman Python", "Ga tau dah"};
    JComboBox<String> cb_matkul = new JComboBox<>(lorem);

    Grading() {
        setTitle("Lembar Penilaian");
        setSize(500, 250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(nim);
        getContentPane().add(nama);
        getContentPane().add(kelas);
        getContentPane().add(matkul);
        getContentPane().add(input_nama);
        getContentPane().add(input_nim);
        getContentPane().add(a);
        getContentPane().add(b);
        getContentPane().add(c);
        getContentPane().add(kelas_a);
        getContentPane().add(kelas_b);
        getContentPane().add(kelas_c);
        getContentPane().add(cb_matkul);
        getContentPane().add(search);
        getContentPane().add(edit);
        getContentPane().add(simpan);
        getContentPane().add(hapus);
        getContentPane().add(keluar);

        //Setup the position
        nim.setBounds(10, 15, 30, 20);
        input_nim.setBounds(130, 15, 125, 23);
        search.setBounds(280, 15, 195, 23);
        nama.setBounds(10, 50, 60, 20);
        input_nama.setBounds(130, 50, 345, 23);
    }

    public static void main(String[] args) {
        Grading g = new Grading();
        g.object();
    }

}
