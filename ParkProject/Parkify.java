package ParkProject;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.event.*;

import java.awt.event.*;
import java.awt.*;
import java.util.Locale;
import java.text.NumberFormat;

public class Parkify extends JFrame {
    JLabel title = new JLabel("Parkify");
    JLabel datetime = new JLabel();
    JTextArea inputPlat = new JTextArea();
    JTextArea filter = new JTextArea();
    JButton deleteButton = new JButton("Out");
    JButton addButton = new JButton("In");
    String[] tipeKendaraan = {"Motor", "Mobil"};
    JComboBox<String> pilihanKendaraan = new JComboBox<>(tipeKendaraan);
    JTable dataTable = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JLabel seachlabel = new JLabel("Search:");

    Font inputFont = new Font("SansSerif", Font.BOLD, 15);

    Parkify() {
        setTitle("Parkify : Parking Management App");
        setLocationRelativeTo(null);
        setSize(660, 600);
        setBackground(new Color(255, 255, 255));
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timedateWidget();
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(32, 136, 203)));
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(title);
        getContentPane().add(inputPlat);
        getContentPane().add(deleteButton);
        getContentPane().add(addButton);
        getContentPane().add(datetime);
        getContentPane().add(pilihanKendaraan);
        getContentPane().add(filter);
        getContentPane().add(seachlabel);
        
        title.setFont(new Font("Harlow Solid Italic", Font.BOLD, 40));
        title.setBounds(250, 15, 300, 60);
        datetime.setBounds(478, 80, 200, 23);
        inputPlat.setBounds(30, 132, 150, 23);
        inputPlat.setFont(new Font("SansSerif", Font.BOLD, 20));
        pilihanKendaraan.setFont(inputFont);
        pilihanKendaraan.setBounds(190, 130, 100, 25);
        addButton.setBounds(300, 130, 100, 25);
        deleteButton.setBounds(410, 130, 100, 25);
        filter.setBounds(85, 170, 100, 25);
        seachlabel.setBounds(30, 170, 70, 25);
        filter.setFont(new Font("SansSerif", Font.BOLD, 15));

        //Buttons
        addButton.setBackground(new Color(35, 149, 154));
        deleteButton.setBackground(new Color(232, 57, 95));
        

    }

    void timedateWidget() {
        // Widget Hari dan Jam
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                datetime.setFont(new Font("Century", Font.PLAIN, 15));
                datetime.setText(dt.format(now));
            }
        });
        timer.start();
    }

    void event() {
        // Table
        dataTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        dataTable.getTableHeader().setOpaque(false);
        dataTable.getTableHeader().setBackground(new Color(35, 149, 154));
        dataTable.getTableHeader().setForeground(new Color(255, 255, 255));
        dataTable.setSelectionBackground(new Color(232, 57, 95));
        dataTable.setRowHeight(26);
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
        dataPanel.setBounds(30, 200, 590, 300);
        
        TableColumnModel columnModel = dataTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(28);
        columnModel.getColumn(0).setMaxWidth(28);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(0).setCellRenderer(centerRenderer);

        // Timer to update the table data periodically
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTable(model);
            }
        });
        timer.start();

        // Load initial data
        updateTable(model);

        //Filter table
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(dataTable.getModel());
        dataTable.setRowSorter(rowSorter);
        filter.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e)  {
                    String text = filter.getText();

                    if(text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                    String text = filter.getText(); 
                    
                    if(text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("next update deh bang hehe");
            }
        });

        // Auto Capslock input plat
        inputPlat.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                    e.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
        });

        filter.addKeyListener(new KeyAdapter() {
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
                    inputPlat.setText(modelcopy.getValueAt(selectRowIndex, 1).toString());
                }
            }
        });

        //Delete button event
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
    }
}
 