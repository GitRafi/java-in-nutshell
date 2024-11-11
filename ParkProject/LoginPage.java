package ParkProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class LoginPage extends JFrame {
    JLabel username = new JLabel("Username");
    JTextField kotakuser = new JTextField();
    JLabel password = new JLabel("Password");
    JPasswordField kotakpass = new JPasswordField();
    JButton login = new JButton("Login");
    JButton exit = new JButton("Exit");
    JCheckBox showPassCB = new JCheckBox();

    private Connection connection;

    LoginPage() {
        setTitle("Login Admin");
        setLocation(200, 100);
        setBackground(new Color(255, 255, 255));
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeDatabaseConnection();

        login.addActionListener(e -> loginAdmin());
        exit.addActionListener(e -> System.exit(0));

        showPassCB.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    kotakpass.setEchoChar('*');
                } else {
                    kotakpass.setEchoChar((char) 0);
                }
            }
        });

        objek();
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
        getContentPane().add(exit);
        getContentPane().add(showPassCB);

        username.setBounds(50, 50, 80, 30);
        kotakuser.setBounds(150, 50, 180, 30);
        password.setBounds(50, 100, 80, 30);
        kotakpass.setBounds(150, 100, 180, 30);
        showPassCB.setBounds(250, 140, 50, 50);
        login.setBounds(100, 200, 80, 30);
        exit.setBounds(200, 200, 80, 30);
        showPassCB.setBounds(200, 100, 15, 15);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
