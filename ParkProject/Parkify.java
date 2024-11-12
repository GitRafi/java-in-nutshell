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
import java.awt.image.BufferedImage;
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
    JPanel notaMasuk = new JPanel();


    Parkify() {
        setTitle("Parkify : Parking Management App");
        setLocationRelativeTo(null);
        setSize(660, 600);
        setBackground(new Color(255, 255, 255));
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupFooterPanel();
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(26, 30, 86)));
    }

    void setupFooterPanel() {
        // Create a footer panel
        JPanel footerPanel = new JPanel();
        JLabel tanggalJam = new JLabel("Tanggal,Jam: ");
        JLabel kelompok = new JLabel("Kelompok 1©");
        footerPanel.setLayout(null);
        footerPanel.setBackground(new Color(26, 30, 86));
        footerPanel.setBounds(0, 530, 660, 30);

        // Add the datetime label to the footer panel
        datetime.setForeground(Color.WHITE);
        footerPanel.add(datetime);
        timedateWidget();
        footerPanel.add(tanggalJam);
        footerPanel.add(kelompok);
        tanggalJam.setBounds(1, 5, 150, 20);
        datetime.setBounds(115, 5, 200, 20);
        kelompok.setBounds(540, 5, 100, 20);
        tanggalJam.setForeground(Color.WHITE);
        kelompok.setForeground(Color.WHITE);
        tanggalJam.setFont(new Font("CaskaydiaMono NFM SemiBold", Font.PLAIN, 15));
        kelompok.setFont(new Font("CaskaydiaMono NFM SemiBold", Font.PLAIN, 15));

        // Add the footer panel to the main frame at the bottom
        getContentPane().add(footerPanel);
        
    }

    void setupNotaMasukWindow(String plat, String tipeKendaraan, String timeIn) {
        JFrame notaMasukWindow = new JFrame("Nota Masuk");
        notaMasukWindow.setSize(400, 350);
        notaMasukWindow.setLocationRelativeTo(this);
        notaMasukWindow.setLayout(null); // Set null layout

        // Nomer Plat Label and Text Field
        JLabel platLabel = new JLabel("Nomer Plat:");
        platLabel.setBounds(20, 20, 100, 25);
        notaMasukWindow.add(platLabel);

        JTextField platField = new JTextField(plat);
        platField.setBounds(130, 20, 200, 25);
        platField.setEditable(false);
        platField.setEnabled(false);
        notaMasukWindow.add(platField);
        platField.setForeground(Color.BLACK);

        // Tipe Kendaraan Label and Text Field
        JLabel tipeKendaraanLabel = new JLabel("Tipe Kendaraan:");
        tipeKendaraanLabel.setBounds(20, 60, 100, 25);
        notaMasukWindow.add(tipeKendaraanLabel);

        JTextField tipeKendaraanField = new JTextField(tipeKendaraan);
        tipeKendaraanField.setBounds(130, 60, 200, 25);
        tipeKendaraanField.setEditable(false);
        tipeKendaraanField.setEnabled(false);
        notaMasukWindow.add(tipeKendaraanField);
        tipeKendaraanField.setForeground(Color.BLACK);

        // Jam Masuk Label and Text Field
        JLabel timeInLabel = new JLabel("Jam Masuk:");
        timeInLabel.setBounds(20, 100, 100, 25);
        notaMasukWindow.add(timeInLabel);

        JTextField timeField = new JTextField(timeIn);
        timeField.setBounds(130, 100, 200, 25);
        timeField.setEditable(false);
        timeField.setEnabled(false);
        notaMasukWindow.add(timeField);
        timeField.setForeground(Color.BLACK);

        JLabel msg = new JLabel("Jangan tinggalkan barang berharga di Kendaraan!");
        msg.setBounds(50, 220, 400, 30);
        notaMasukWindow.add(msg);

        JButton printButton = new JButton("Print");
        printButton.setBounds(145, 255, 80, 30);
        printButton.setBackground(new Color(232, 57, 95));
        printButton.setForeground(new Color(255, 255, 255));
        notaMasukWindow.add(printButton);


    // QR Code Label
    try {
        BufferedImage qrCodeImage = QRCodeGenerator.generateQRCodeImage(plat);
        JLabel qrCodeLabel = new JLabel(new ImageIcon(qrCodeImage));
        qrCodeLabel.setBounds(145, 140, 80, 80); // Position and size for the QR code
        notaMasukWindow.add(qrCodeLabel);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(notaMasukWindow, "Failed to generate QR code", "Error", JOptionPane.ERROR_MESSAGE);
    }

    notaMasukWindow.setVisible(true);
}
 

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(title);
        getContentPane().add(inputPlat);
        getContentPane().add(deleteButton);
        getContentPane().add(addButton);
        getContentPane().add(pilihanKendaraan);
        getContentPane().add(filter);
        getContentPane().add(seachlabel);
        
        title.setFont(new Font("Harlow Solid Italic", Font.BOLD, 40));
        title.setBounds(255, 25, 300, 60);
        title.setForeground(new Color(60, 67, 163));
        seachlabel.setForeground(new Color(60, 67, 163));
        // datetime.setBounds(478, 80, 200, 23);
        inputPlat.setBounds(30, 130, 150, 25);
        inputPlat.setFont(new Font("SansSerif", Font.BOLD, 15));
        pilihanKendaraan.setFont(inputFont);
        pilihanKendaraan.setBounds(190, 130, 100, 25);
        addButton.setBounds(300, 130, 100, 25);
        deleteButton.setBounds(410, 130, 100, 25);
        filter.setBounds(85, 170, 100, 25);
        seachlabel.setBounds(30, 169, 70, 25);
        filter.setFont(new Font("SansSerif", Font.BOLD, 15));

        //Buttons
        addButton.setBackground(new Color(60, 67, 163));
        addButton.setForeground(new Color(255, 255, 255));
        deleteButton.setBackground(new Color(232, 57, 95));
        deleteButton.setForeground(new Color(255, 255, 255));
        filter.setBorder(BorderFactory.createBevelBorder(1, (new Color(60, 67, 163)), (new Color(60, 67, 163))));
        inputPlat.setBorder(BorderFactory.createBevelBorder(1, (new Color(60, 67, 163)), (new Color(60, 67, 163))));

        pilihanKendaraan.setBackground(new Color(60, 67, 163));
        pilihanKendaraan.setForeground(Color.WHITE);
        pilihanKendaraan.setOpaque(true);
        

    }

    void timedateWidget() {
        // Widget Hari dan Jam
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd,HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                datetime.setFont(new Font("CaskaydiaMono NFM SemiBold", Font.PLAIN, 15));
                datetime.setText(dt.format(now));
            }
        });
        timer.start();
    }

    void event() {
        // Table
        dataTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        dataTable.getTableHeader().setOpaque(false);
        dataTable.getTableHeader().setBackground(new Color(60, 67, 163));
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

          addButton.addActionListener(e -> {
            try {
                String plat = inputPlat.getText();
                String tipeKendaraan = (String) pilihanKendaraan.getSelectedItem();
                DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd , HH:mm");
                String currentTime = dt.format(LocalDateTime.now());

                setupNotaMasukWindow(plat, tipeKendaraan, currentTime);


            } catch (Exception err) {
                err.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error adding data: " + err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            final String getQuery = "SELECT ROW_NUMBER() OVER (ORDER BY CASE WHEN tipe_kendaraan = 'Motor' THEN 1 ELSE 2 END, time_in, plat) AS row_num, plat, tipe_kendaraan, DATE_FORMAT(time_in, '%d %b %Y %H:%i') AS formated_time_in, time_in FROM vehicle_parked ORDER BY CASE WHEN tipe_kendaraan = 'Motor' THEN 1 ELSE 2 END, time_in, plat;";
            Connection con = SQLCon.getConnetion();
            PreparedStatement ps = con.prepareStatement(getQuery);
            ResultSet rs = ps.executeQuery();
            model.setRowCount(0); 

            while (rs.next()) {
                String row = rs.getString("row_num");
                String plat = rs.getString("plat");
                String tipeKendaraan = rs.getString("tipe_kendaraan");
                String formatedTime = rs.getString("formated_time_in");
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

                Object[] data = new Object[] {row, plat, tipeKendaraan, formatedTime, formatTarif};
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
