package ParkProject;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;
import java.util.Locale;
import java.text.NumberFormat;

public class Parkify extends JFrame {
    JLabel title = new JLabel("Plaza Parking Management");
    JLabel datetime = new JLabel();
    JTextArea inputPlat = new JTextArea();
    JButton searchButton = new JButton("Search");
    JButton deleteButton = new JButton("Out");
    JButton addButton = new JButton("In");
    String[] tipeKendaraan = {"Motor", "Mobil"};
    JComboBox<String> pilihanKendaraan = new JComboBox<>(tipeKendaraan);
    JTable dataTable = new JTable();
    DefaultTableModel model = new DefaultTableModel();

    // Font
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font inputFont = new Font("SansSerif", Font.BOLD, 15);
    Font date = new Font("SansSerif", Font.ITALIC, 15);

    Parkify() {
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
        // Widget Hari dan Jam
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                datetime.setFont(date);
                datetime.setText(dt.format(now));
            }
        });
        timer.start();
    }

    void event() {
        // Table
        dataTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        dataTable.getTableHeader().setOpaque(false);
        dataTable.getTableHeader().setBackground(new Color(32, 136, 203));
        JScrollPane dataPanel = new JScrollPane(dataTable);
        Object[] columnsName = new Object[5];
        columnsName[0] = "No";
        columnsName[1] = "Nomer Plat";
        columnsName[2] = "Tipe kendaraan";
        columnsName[3] = "Tanggal, Jam masuk";
        columnsName[4] = "Total tarif";
        model.setColumnIdentifiers(columnsName);

        dataTable.setModel(model);
        getContentPane().add(dataPanel);
        dataPanel.setBounds(30, 180, 590, 300);

        // Timer to update the table data periodically
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTable(model);
            }
        });
        timer.start();

        // Load initial data
        updateTable(model);

        // Auto Capslock input plat
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

                    // Update table after adding a new vehicle
                    updateTable(model);

                } catch (SQLException err) {
                    err.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data gagal ditambahkan! Error: " + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dataTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel modelcopy = (DefaultTableModel) dataTable.getModel();
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

                    updateTable(model);

                } catch (SQLException err) {
                    err.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus! Error: " + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    void updateTable(DefaultTableModel model) {
        try {
            final String getQuery = "SELECT ROW_NUMBER() OVER (ORDER BY CASE WHEN tipe_kendaraan = 'Motor' THEN 1 ELSE 2 END, time_in, plat) AS row_num, plat, tipe_kendaraan, time_in FROM vehicle_parked ORDER BY CASE WHEN tipe_kendaraan = 'Motor' THEN 1 ELSE 2 END, time_in, plat;;";
            Connection con = SQLCon.getConnetion();
            PreparedStatement ps = con.prepareStatement(getQuery);
            ResultSet rs = ps.executeQuery();
            model.setRowCount(0); 

            while (rs.next()) {
                String row = rs.getString("row_num");
                String plat = rs.getString("plat");
                String tipeKendaraan = rs.getString("tipe_kendaraan");
                Timestamp timeIn = rs.getTimestamp("time_in");

                Timestamp timeNow = new Timestamp(System.currentTimeMillis());
                long milisecond = timeNow.getTime() - timeIn.getTime();
                // int hours = (int) (milisecond / (1000 * 60 * 60));
                int hours = (int) (milisecond / (1000));

                int tarifMasuk;

                if (tipeKendaraan.equals("Motor")) {
                    tarifMasuk = 2000;
                } else if (tipeKendaraan.equals("Mobil")) {
                    tarifMasuk = 5000;
                } else {
                    tarifMasuk = 2000;
                }

                int akhirTarif = tarifMasuk + hours;
                @SuppressWarnings("deprecation")
                NumberFormat formatrp = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
                String formatTarif = formatrp.format(akhirTarif);

                // if (hours > 1) {
                //     totalTarif += (hours - 1) * 1000;
                // }

                Object[] data = new Object[] {row, plat, tipeKendaraan, timeIn.toString(), formatTarif};
                model.addRow(data);
            }

            model.fireTableDataChanged();
            dataTable.revalidate();
            dataTable.repaint();

        } catch (SQLException err) {
            SQLCon.printSQLException(err);
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkan! Error: " + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Parkify app = new Parkify();
        app.object();
        app.event();
        app.timedateWidget();
    }
}
 