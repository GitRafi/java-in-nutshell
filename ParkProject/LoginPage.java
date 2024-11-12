package ParkProject;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class LoginPage extends JFrame {
    JLabel title = new JLabel("Parkify");
    JLabel desc = new JLabel("Parking Management App");
    JLabel loginLabel = new JLabel("Login");
    JLabel username = new JLabel("Username");
    JTextField kotakuser = new JTextField();
    JLabel password = new JLabel("Password");
    JPasswordField kotakpass = new JPasswordField();
    JButton login = new JButton("Login");
    JCheckBox showPassCB = new JCheckBox();
    JLabel msg = new JLabel("Show password");
    JPanel Footer = new JPanel();

    private Connection connection;

    LoginPage() {
        setTitle("Login Admin");
        setBackground(new Color(255, 255, 255));
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(60, 67, 163)));
        initializeDatabaseConnection();

        setVisible(true);
        login.addActionListener(e -> loginAdmin());
        objek();

        showPassCB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    kotakpass.setEchoChar((char) 0);
                } else {
                    kotakpass.setEchoChar('•');
                }
            }
        });

    }

    private void initializeDatabaseConnection() {
        try {
            connection = SQLCon.getConnetion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }
    }

    private void loginAdmin() {
        String user = kotakuser.getText();
        @SuppressWarnings("deprecation")
        String pass = kotakpass.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silahkan masukkan username dan password.");
            return;
        }

        try {
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Parkify app = new Parkify();
                app.object();
                app.event();
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Login failed: " + e.getMessage());
        }
    }

    void objek() {
        getContentPane().setLayout(null);
        getContentPane().add(username);
        getContentPane().add(kotakuser);
        getContentPane().add(password);
        getContentPane().add(kotakpass);
        getContentPane().add(login);
        getContentPane().add(showPassCB);
        getContentPane().add(title);
        getContentPane().add(desc);
        getContentPane().add(loginLabel);
        getContentPane().add(msg);

        title.setBounds(133, 15, 400, 60);
        username.setBounds(70, 119, 80, 30);
        kotakuser.setBounds(135, 120, 180, 30);
        password.setBounds(70, 169, 80, 30);
        kotakpass.setBounds(135, 170, 180, 30);
        login.setBounds(135, 245, 120, 30);
        showPassCB.setBounds(130, 205, 25, 25);
        desc.setBounds(120, 65, 150, 30);
        msg.setBounds(155, 201, 150, 30);

        kotakuser.setFont(new Font("CaskaydiaMono NF SemiBold", Font.PLAIN, 16));
        kotakpass.setFont(new Font("CaskyadiaMono NF SemiBold", Font.PLAIN, 16));
        title.setFont(new Font("Harlow Solid Italic", Font.BOLD, 35));

        login.setForeground(new Color(60, 67, 163));
        login.setOpaque(false);
        login.setBackground(new Color(60, 67, 163));
        login.setBorder(BorderFactory.createBevelBorder(1, (new Color(60, 67, 163)), (new Color(60, 67, 163))));

    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
