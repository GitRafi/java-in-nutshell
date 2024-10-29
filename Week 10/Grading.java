import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Grading extends JFrame {

    JLabel nim = new JLabel("NIM");
    JLabel nama = new JLabel("Nama");
    JLabel kelas = new JLabel("Kelas");
    JLabel matkul = new JLabel("Mata Kuliah");
    JLabel kelas_i = new JLabel("I");
    JLabel kelas_j = new JLabel("J");
    JLabel kelas_k = new JLabel("K");
    JTextArea input_nim = new JTextArea();
    JTextArea input_nama = new JTextArea();
    JRadioButton i = new JRadioButton();
    JRadioButton j = new JRadioButton();
    JRadioButton k = new JRadioButton();
    JButton search = new JButton("Cari");
    JButton edit = new JButton("Edit");
    JButton simpan = new JButton("Simpan");
    JButton hapus = new JButton("Hapus");
    JButton keluar = new JButton("Keluar");
    String[] lorem = {"Kalkulus", "Pemrograman Python", "Ga tau dah"};
    JComboBox<String> cb_matkul = new JComboBox<>(lorem);
    Font font1 = new Font("Sansserif", Font.BOLD, 15);

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
        getContentPane().add(i);
        getContentPane().add(j);
        getContentPane().add(k);
        getContentPane().add(kelas_i);
        getContentPane().add(kelas_j);
        getContentPane().add(kelas_k);
        getContentPane().add(cb_matkul);
        getContentPane().add(search);
        getContentPane().add(edit);
        getContentPane().add(simpan);
        getContentPane().add(hapus);
        getContentPane().add(keluar);

        //Set Font for inputs
        input_nim.setFont(font1);
        input_nama.setFont(font1);
        kelas_i.setFont(font1);
        kelas_j.setFont(font1);
        kelas_k.setFont(font1);

        //Setup the position
        nim.setBounds(10, 15, 30, 20);
        input_nim.setBounds(130, 15, 125, 23);
        search.setBounds(280, 15, 195, 23);
        nama.setBounds(10, 50, 60, 20);
        input_nama.setBounds(130, 50, 345, 23);
        kelas.setBounds(10, 85, 60, 20);
        i.setBounds(130, 85, 20, 20);
        kelas_i.setBounds(150, 84, 20, 20);
        j.setBounds(175, 85, 20, 20);
        kelas_j.setBounds(195, 84, 20, 20);
        k.setBounds(215, 85, 20, 20);
        kelas_k.setBounds(235, 84, 20, 20);
        matkul.setBounds(10, 120, 90, 20);
        cb_matkul.setBounds(130, 120, 200, 20);
        edit.setBounds(10, 155, 100, 23);
        simpan.setBounds(120, 155, 100, 23);
        hapus.setBounds(230, 155, 100, 23);
        keluar.setBounds(375, 155, 100, 23);
    }

    void event() {
        
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String params = String.valueOf(input_nim.getText());
                    final String searchQuery = "SELECT * FROM siswa WHERE NIM = ?";
                    Connection con = SQLCon.getConnetion();
                    PreparedStatement ps = con.prepareStatement(searchQuery);
                    ps.setString(1, params);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        String nama = rs.getString("fullname");
                        String kelas = rs.getString("class");
                        System.out.println(nama);
                        System.out.println(kelas);
                        input_nama.setText(nama);
                        if (kelas.equals("I")) {
                            i.setSelected(true);
                            j.setSelected(false);
                            k.setSelected(false);
                        } else if (kelas.equals("J")) {
                            j.setSelected(true);
                            i.setSelected(false);
                            k.setSelected(false);
                        } else if (kelas.equals("K")) {
                            k.setSelected(true);
                            i.setSelected(false);
                            j.setSelected(false);
                        }
                    }
                } catch (SQLException err) {
                    SQLCon.printSQLException(err);
                }
            }
        });
    }

    public static void main(String[] args) {
                Grading g = new Grading();
                g.object();
                g.event();
    }
}
