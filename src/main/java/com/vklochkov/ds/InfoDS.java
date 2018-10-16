package com.vklochkov.ds;

import com.vklochkov.bean.InfoBean;
import com.vklochkov.utils.MySQLHelper;

import java.sql.*;

public class InfoDS {
    public InfoDS () { }

    /*
     *  Get shop info
     */
    public InfoBean getInfo () {
        return this.sendRequest("SELECT * FROM Info;", "select");
    }

    /*
     * Save info
     */
    public InfoBean saveInfo (InfoBean info) {
        return this.sendRequest("UPDATE Info SET shopName='" + info.getShopName() + "', foundationDate='" + info.getFoundationDate() + "', author='" + info.getAuthor() + "', about='" + info.getAbout() + "';", "update");
    }

    private InfoBean sendRequest (String query, String type) {
        String shopName = "";
        String foundationDate = "";
        String author = "";
        String about = "";

        try {
            if (type == "select") {
                ResultSet rs = new MySQLHelper().sendSelectSQLRequest(query);

                while (rs.next()) {
                    shopName = rs.getString("shopName");
                    foundationDate = rs.getString("foundationDate");
                    author = rs.getString("author");
                    about = rs.getString("about");
                }

                return new InfoBean(shopName, foundationDate, author, about);
            } else if (type == "update") {
                int rs = new MySQLHelper().sendUpdateSQLRequest(query);

                if (rs != 0) {
                    return sendRequest("SELECT * FROM Info;", "select");
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return new InfoBean("", "", "", "");
    }
}
