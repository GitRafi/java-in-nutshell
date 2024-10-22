import java.awt.*;
import javax.swing.*;

public class Laundry extends JFrame {
    Font font_judul = new Font("SansSerif", Font.BOLD, 18);
    JLabel app = new JLabel("Aplikasi Laundry");
    JLabel nama = new JLabel("Nama pelanggan:");
    JLabel nota = new JLabel("No. Nota:");
    JLabel alamat = new JLabel("Alamat:");
    JLabel jenis_laundry = new JLabel("Jenis Laundry:");
    JLabel jumlah = new JLabel("Jumlah:");
    JLabel kg = new JLabel("Kg");
    JLabel tambahan = new JLabel("Tambahan:");
    JLabel antar_jemput = new JLabel("Antar Jemput?:");
    JLabel total = new JLabel("Total Bayar:");
    JLabel karpet = new JLabel("Karpet");
    JLabel bed = new JLabel("Bed Cover");
    JLabel output = new JLabel("Hasil Output");
    JTextField input_nota = new JTextField();
    JTextField input_nama = new JTextField();
    JTextField input_alamat = new JTextField();
    JTextField input_jenis = new JTextField();
    JTextField input_kg = new JTextField();
    JTextField input_karpet = new JTextField();
    JTextField input_bed = new JTextField();
    JTextField input_totalbayar = new JTextField();
    JCheckBox cb_karpet = new JCheckBox();
    JCheckBox cb_bed = new JCheckBox();
    final String dd_laundry[] = {"Express", "Normal"};
    JComboBox<String> comboBox1 = new JComboBox<>(dd_laundry);
    // JPanel panel = new JPanel();
    JTextArea ta_big = new JTextArea();
    JTextArea ta_small = new JTextArea();
    JRadioButton ya = new JRadioButton("Ya");
    JRadioButton tidak = new JRadioButton("Tidak");
    JButton bersih = new JButton("Bersih");
    JButton Keluar = new JButton("Keluar");
    JButton tampil = new JButton("Tampil");



    Laundry() {
        setTitle("Aplikasi Laundry");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(app);
        getContentPane().add(nama);
        getContentPane().add(nota);
        getContentPane().add(alamat);
        getContentPane().add(jenis_laundry);
        getContentPane().add(jumlah);
        getContentPane().add(kg);
        getContentPane().add(tambahan);
        getContentPane().add(karpet);
        getContentPane().add(bed);
        getContentPane().add(antar_jemput);
        getContentPane().add(total);
        getContentPane().add(input_nota);
        getContentPane().add(input_nama);
        getContentPane().add(input_alamat);
        getContentPane().add(input_jenis);
        getContentPane().add(input_karpet);
        getContentPane().add(input_kg);
        getContentPane().add(input_bed);
        getContentPane().add(input_totalbayar);
        getContentPane().add(comboBox1);
        getContentPane().add(cb_bed);
        getContentPane().add(cb_karpet);
        // getContentPane().add(panel);
        getContentPane().add(ta_big);
        getContentPane().add(ta_small);
        getContentPane().add(output);
        getContentPane().add(ya);
        getContentPane().add(tidak);
        getContentPane().add(bersih);
        getContentPane().add(Keluar);
        getContentPane().add(tampil);

        //Set Font
        app.setFont(font_judul);

        //Setting position
        app.setBounds(265, 13, 200, 30);
        nota.setBounds(10, 70, 150, 20);
        input_nota.setBounds(10, 95, 250, 23);
        nama.setBounds(10, 125, 150, 20);
        input_nama.setBounds(10, 150, 250, 23);
        alamat.setBounds(10, 180, 150, 20 );
        input_alamat.setBounds(10, 205, 250, 23);
        jenis_laundry.setBounds(10, 255, 90, 20);
        comboBox1.setBounds(100, 255, 80, 20);
        input_jenis.setBounds(190, 255, 70, 20);
        jumlah.setBounds(10, 290, 70, 20 );
        input_kg.setBounds(65, 290,30, 23);
        kg.setBounds(100, 290, 50, 20);
        tambahan.setBounds(10, 330, 70, 20);
        cb_karpet.setBounds(75, 332, 20, 20);
        karpet.setBounds(100, 331, 50, 23);
        input_karpet.setBounds(170, 332, 80, 20);
        cb_bed.setBounds(75, 360, 20, 20);
        bed.setBounds(100, 359, 70, 23);
        input_bed.setBounds(170, 360, 80, 20);
        // panel.setBounds(425, 93,250, 180);
        ta_big.setBounds(425, 93, 250, 180);
        output.setBounds(510, 75, 100, 20);
        ta_small.setBounds(425, 110, 110, 110);
        antar_jemput.setBounds(425, 290, 100, 20);
        ya.setBounds(520, 291, 50, 20);
        tidak.setBounds(570, 291, 90, 20);
        total.setBounds(425, 360, 80, 20);
        input_totalbayar.setBounds(500, 361, 150, 20);
        bersih.setBounds(160, 410, 100, 30);
        Keluar.setBounds(280, 410, 100, 30);
        tampil.setBounds(400, 410, 100, 30);
        // panel.add(ta_small);

        //Other properties etc
        // panel.setBorder(BorderFactory.createLineBorder(Color.black));
        ta_big.setBorder(BorderFactory.createLineBorder(Color.black));
        ta_small.setBackground(Color.RED);
        // panel.setBackground(Color.gray);
    }

    public static void main(String[] args) {
        Laundry laundry = new Laundry();
        laundry.object();
    }
    
}
