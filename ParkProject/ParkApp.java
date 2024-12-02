package ParkProject;
import java.sql.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;

public class ParkApp extends JFrame {
    JLabel title = new JLabel("Plaza Parking Management");
    JLabel datetime = new JLabel();
    JTextArea inputPlat = new JTextArea();
    JButton searchButton = new JButton("Search");
    JButton deleteButton = new JButton("Out");
    JButton addButton = new JButton("In");
    String[] tipeKendaraan = {"Motor", "Mobil"};
    JComboBox<String> pilihanKendaraan = new JComboBox<>(tipeKendaraan);


    //Font
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font inputFont = new Font("SansSerif", Font.BOLD, 15);
    Font date = new Font("SansSerif", Font.ITALIC, 15);

    ParkApp() {
        setTitle("Plaza Parking App");
        setLocationRelativeTo(null);
        setSize(660, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(title);
        getContentPane().add(inputPlat);
        getContentPane().add(searchButton);
        getContentPane().add(deleteButton);
        getContentPane().add(addButton);
        getContentPane().add(datetime);
        getContentPane().add(pilihanKendaraan);
        
        title.setFont(font1);
        title.setBounds(220, 30, 300, 25);
        datetime.setBounds(478, 70, 200, 23);
        inputPlat.setBounds(30, 122, 150, 23);
        inputPlat.setFont(inputFont);
        pilihanKendaraan.setFont(inputFont);
        searchButton.setBounds(300, 120, 100, 25);
        pilihanKendaraan.setBounds(190, 120, 100, 25);
        addButton.setBounds(410, 120, 100, 25);
        deleteButton.setBounds(520, 120, 100, 25);
    }

    void timedateWidget() {

        //Widget Hari dan Jam
        while (true) {
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        datetime.setFont(date);
        datetime.setText(dt.format(now));
        }

    }

    void event() {

        //Table
        JTable dataTable = new JTable();
        // dataTable.setEnabled(false);
        JScrollPane dataPanel = new JScrollPane(dataTable);
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[4];
        columnsName[0] = "Nomer Plat";
        columnsName[1] = "Tipe kendaraan";
        columnsName[2] = "Tanggal, Jam masuk";
        columnsName[3] = "Total tarif";
        model.setColumnIdentifiers(columnsName);

        try {
            final String getQuery = "SELECT * FROM vehicle_parked ORDER BY CASE WHEN tipe_kendaraan = 'Motor' THEN 1 WHEN tipe_kendaraan = 'Mobil' THEN 2 ELSE 3 END;";
            Connection con = SQLCon.getConnetion();
            PreparedStatement ps = con.prepareStatement(getQuery);
            ResultSet rs = ps.executeQuery();
            Object[] data;

            while (rs.next()) {
               String plat = rs.getString("plat");
               String tipeKendaraan = rs.getString("tipe_kendaraan");
               Timestamp timeIn = rs.getTimestamp("time_in");

               Timestamp timeNow = new Timestamp(System.currentTimeMillis());
               long milisecond = timeNow.getTime() - timeIn.getTime();
            //    int hours = (int) (milisecond / (1000 * 60 * 60));
               int hours = (int) (milisecond / (1000));

               int totalTarif = 2000;
               if (hours > 1) {
                totalTarif += (hours - 1) * 1;
               }

               @SuppressWarnings("deprecation")
            NumberFormat formatrp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
               String formatTarif = formatrp.format(totalTarif);
               data = new Object[]  {plat, tipeKendaraan, timeIn.toString(), "Rp." + formatTarif};
               model.addRow(data);
            }

        } catch (SQLException err) {
            SQLCon.printSQLException(err);
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan! Error: " + err.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
        } finally {
            System.out.println("Done table process");
        }

        dataTable.setModel(model);
        getContentPane().add(dataPanel);
        dataPanel.setBounds(30, 180, 590, 300);

        //Auto Capslock input plat
        inputPlat.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                String plat = String.valueOf(inputPlat.getText());
                String tipeKendaraan = String.valueOf(pilihanKendaraan.getSelectedItem());
                final String addQuery = "INSERT INTO vehicle_parked (plat, tipe_kendaraan, time_in) VALUES (?, ?, CURRENT_TIMESTAMP);";
                Connection con = SQLCon.getConnetion();
                PreparedStatement ps = con.prepareStatement(addQuery);
                ps.setString(1, plat);
                ps.setString(2, tipeKendaraan);
                ps.executeUpdate();
                model.setRowCount(0);
                dataTable.revalidate();
                
                //Ambil data ulang
                final String getQuery = "SELECT * FROM vehicle_parked ORDER BY CASE WHEN tipe_kendaraan = 'Motor' THEN 1 WHEN tipe_kendaraan = 'Mobil' THEN 2 ELSE 3 END;";
                PreparedStatement update = con.prepareStatement(getQuery);
                ResultSet rs = update.executeQuery();
                Object[] data;
            
                while (rs.next()) {
                    data = new Object[]  {rs.getString("plat"), rs.getString("tipe_kendaraan"), rs.getString("time_in")};
                    model.addRow(data);
                }
 
                } catch (SQLException err) {
                    err.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data gagal ditambahkan! Error: " + err.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
                }

            }
        });       
        
        dataTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel modelcopy = (DefaultTableModel)dataTable.getModel();
                int selectRowIndex = dataTable.getSelectedRow();

                if (selectRowIndex != -1) {
                inputPlat.setText(modelcopy.getValueAt(selectRowIndex, 0).toString());
                }
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String plat = String.valueOf(inputPlat.getText());
                    final String deleteQuery = "DELETE FROM vehicle_parked WHERE plat = ?;";
                    Connection con = SQLCon.getConnetion();
                    PreparedStatement ps = con.prepareStatement(deleteQuery);
                    ps.setString(1, plat);
                    ps.executeUpdate();
                    model.setRowCount(0);
                    dataTable.revalidate();

                    final String getQuery = "SELECT * FROM vehicle_parked ORDER BY CASE WHEN tipe_kendaraan = 'Motor' THEN 1 WHEN tipe_kendaraan = 'Mobil' THEN 2 ELSE 3 END;";
                    PreparedStatement update = con.prepareStatement(getQuery);
                    ResultSet rs = update.executeQuery();
                    Object[] data;
            
                    while (rs.next()) {
                    data = new Object[]  {rs.getString("plat"), rs.getString("tipe_kendaraan"), rs.getString("time_in")};
                    model.addRow(data);
                    }

                } catch (SQLException err) {
                    err.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus! Error: " + err.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {
        ParkApp app = new ParkApp();
        app.object();
        app.event();
        app.timedateWidget();
    }
}
