import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws Exception {
        String db_url = "jdbc:mysql://localhost:3306/rafi_24051130034";
        String db_user = "root";
        String db_pw = "";

        Connection con = DriverManager.getConnection(db_url, db_user, db_pw);
        Statement st = con.createStatement();

        ResultSet test = st.executeQuery("SELECT * FROM siswa");
        System.out.println(test);
    }
}