package com.vklochkov.ds;

import com.vklochkov.model.Info;

import java.sql.*;

public class InfoDS {
    private Connection connection;

    public InfoDS (Connection connection) {
        this.connection = connection;
    }

    /*
    *  Get shop info
    */
    public Info getInfo () {
        Statement stmt = null;
        ResultSet rs = null;

        String shopName = "";
        String foundationDate = "";
        String author = "";
        String about = "";

        try {
            stmt = this.connection.createStatement();
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
