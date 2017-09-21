import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Class;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

    private static Connection conn = null;
    final static String URL = "jdbc:mysql://localhost:3306/GereVille";

    public static Connection getConnection() {

        if (conn == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(URL, "root", "Wowzillah");
            } catch (SQLException sqlE) {
                System.out.println("Sql Erreur " + sqlE.getMessage());
                throw new RuntimeException();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    public static ArrayList<Ville> findAllVilles() {
        ArrayList<Ville> villes = new ArrayList<>();
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;
        try {
            stm = c.prepareStatement("SELECT * FROM Villes INNER JOIN Pays on paysId=Pays.id");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                int paysid = result.getInt("Pays.id");
                Pays solePays = findOnePays(paysid);

                String nomVille = result.getString("nom");
                int nbhab = result.getInt("habitant");
                String categorie = result.getString("categorie");
                String president = result.getString("president");
                if (president.equals("")) {
                    // if not a capitale.
                    Ville ville = new Ville(id, nomVille, solePays, nbhab);
                    villes.add(ville);
                } else {
                    Capitale capitale = new Capitale(id, nomVille, solePays, nbhab, president);
                    villes.add(capitale);
                }


            }
            result.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return villes;
    }

    public static ArrayList<Pays> findAllPays() {

        ArrayList<Pays> pays = new ArrayList<>();
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;
        try {
            stm = c.prepareStatement("SELECT * FROM Pays");
            ResultSet result = stm.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String nom = result.getString("nom");
                int capitale = result.getInt("capitaleId");
                Pays country = new Pays(id, nom, capitale);
                pays.add(country);
            }

            result.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return pays;
    }

    public static Pays findOnePays(int paysId) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;
        try {
            String request = "SELECT * FROM Pays WHERE id=?";
            stm = c.prepareStatement(request);
            stm.setInt(1, paysId);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String nom = result.getString("nom");
                int capitale = result.getInt("capitaleId");
                return new Pays(id, nom, capitale);
            }

            result.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return null;
    }

    public static ArrayList<Ville> villesFromOnePays(int paysId) {
        ArrayList<Ville> villes = new ArrayList<>();
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;
        try {
            String request = "SELECT * FROM Villes WHERE paysid=?";
            stm = c.prepareStatement(request);
            stm.setInt(1, paysId);
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                Pays solePays = findOnePays(paysId);

                String nomVille = result.getString("nom");
                int nbhab = result.getInt("habitant");
                String categorie = result.getString("categorie");
                String president = result.getString("president");
                if (president.equals("")) {
                    // if not a capitale.
                    Ville ville = new Ville(id, nomVille, solePays, nbhab);
                    villes.add(ville);
                } else {
                    Capitale capitale = new Capitale(id, nomVille, solePays, nbhab, president);
                    villes.add(capitale);
                }


            }
            result.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return villes;
    }
}



