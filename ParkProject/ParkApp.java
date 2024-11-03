package ParkProject;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;

public class ParkApp extends JFrame {
    JLabel title = new JLabel("Plaza Parking Management");
    JTextArea inputPlat = new JTextArea();
    JButton searchButton = new JButton("Search");
    JButton deleteButton = new JButton("Delete");
    JButton addbButton = new JButton("Add");

    //Font
    Font font1 = new Font("SansSerif", Font.BOLD, 20);
    Font inputFont = new Font("SansSerif", Font.BOLD, 13);

    //Table
    DefaultTableModel model = new DefaultTableModel();

    ParkApp() {
        setTitle("Plaza Parking App");
        setLocationRelativeTo(null);
        setSize(700, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void object() {
        getContentPane().setLayout(null);
        getContentPane().add(title);
        getContentPane().add(inputPlat);
        getContentPane().add(searchButton);
        getContentPane().add(deleteButton);
        getContentPane().add(addbButton);
        
        title.setFont(font1);
        title.setBounds(232, 30, 300, 25);
        inputPlat.setBounds(30, 150, 150, 25);
        inputPlat.setFont(inputFont);
        searchButton.setBounds(150, 150, 100, 30);
    }

    public static void main(String[] args) {
        ParkApp app = new ParkApp();
        app.object();
    }
}
