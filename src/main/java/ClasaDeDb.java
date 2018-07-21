import java.io.PrintWriter;
import java.sql.*;

public class ClasaDeDb {
    static void insert(String nume, String telefon){

        try {
            Class.forName("org.postgresql.Driver");

            final String URL = "jdbc:postgresql://54.93.65.5:5432/flavius8";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pSt = conn.prepareStatement("INSERT INTO agenda (nume, telefon) VALUES (?,?)");
            pSt.setString(1,  nume);
            pSt.setString(2, telefon);

            pSt.executeUpdate();
            pSt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void delete(String nume){
        try {
            Class.forName("org.postgresql.Driver");

            final String URL = "jdbc:postgresql://54.93.65.5:5432/flavius8";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pSt = conn.prepareStatement("DELETE FROM agenda WHERE nume=?");
            pSt.setString(1,  nume);

            pSt.executeUpdate();
            pSt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static String[] read() {
        String[] sa = new String[1000];
        try {
            Class.forName("org.postgresql.Driver");

            final String URL = "jdbc:postgresql://54.93.65.5:5432/flavius8";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pSt = conn.prepareStatement("SELECT * FROM agenda");
            ResultSet rs = pSt.executeQuery();

            int temp = 0;
            while (rs.next()) {
                String nume = rs.getString("nume").trim();
                sa[temp] = nume;
                temp++;
                String telefon = rs.getString("telefon").trim();
                sa[temp] = telefon;
                temp++;
            }

            rs.close();
            pSt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sa;
    }
}
