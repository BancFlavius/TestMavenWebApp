import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    static List<Item> read() {
        List<Item> lista = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");

            final String URL = "jdbc:postgresql://54.93.65.5:5432/flavius8";
            final String USERNAME = "fasttrackit_dev";
            final String PASSWORD = "fasttrackit_dev";

            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement pSt = conn.prepareStatement("SELECT * FROM agenda");
            ResultSet rs = pSt.executeQuery();

            while (rs.next()) {
                String nume="0";
                String telefon="0";
                Item i = new Item(nume,telefon);
                 i.setName(rs.getString("nume").trim());
                 i.setPhone(rs.getString("telefon").trim());
                 lista.add(i);
            }

            rs.close();
            pSt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
