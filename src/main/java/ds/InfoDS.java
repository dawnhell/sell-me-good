package ds;

import model.Info;

import java.sql.*;

public class InfoDS {
    public Info getInfo () {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String shopName = "";
        String foundationDate = "";
        String author = "";
        String about = "";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wsdb?user=root&password=root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Info");

            while (rs.next()) {
                shopName = rs.getString("shopName");
                foundationDate = rs.getString("foundationDate");
                author = rs.getString("author");
                about = rs.getString("about");
            }

            return new Info(shopName, foundationDate, author, about);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return new Info("", "", "", "");
    }
}
