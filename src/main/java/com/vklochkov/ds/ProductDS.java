package com.vklochkov.ds;

import com.vklochkov.bean.ProductBean;
import com.vklochkov.utils.MySQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDS {
    public ProductDS() {}

    public ArrayList<ProductBean> getProducts() {
        ArrayList<ProductBean> result = new ArrayList<>();
        try {
            ResultSet rrs = new MySQLHelper().sendSelectSQLRequest("SELECT * FROM Products;");

            while (rrs.next()) {
                result.add(new ProductBean(
                    rrs.getInt("ProductID"),
                    rrs.getInt("ProductLive"),
                    rrs.getInt("ProductCategoryID"),
                    rrs.getInt("ProductUnlimited"),
                    rrs.getFloat("ProductPrice"),
                    rrs.getFloat("ProductWeight"),
                    rrs.getFloat("ProductStock"),
                    rrs.getString("ProductSKU"),
                    rrs.getString( "ProductName"),
                    rrs.getString( "ProductCartDesc"),
                    rrs.getString( "ProductShortDesc"),
                    rrs.getString( "ProductLongDesc"),
                    rrs.getString( "ProductThumb"),
                    rrs.getString( "ProductImage"),
                    rrs.getString( "ProductUpdateDate"),
                    rrs.getString( "ProductLocation")
                ));
            }

        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return result;
    }

    public ProductBean getProduct(int id) {
        ProductBean result = null;
        try {
            ResultSet rrs = new MySQLHelper().sendSelectSQLRequest("SELECT * FROM Products WHERE Products.ProductID=" + id + ";");
            rrs.next();

            result = new ProductBean(
                rrs.getInt("ProductID"),
                rrs.getInt("ProductLive"),
                rrs.getInt("ProductCategoryID"),
                rrs.getInt("ProductUnlimited"),
                rrs.getFloat("ProductPrice"),
                rrs.getFloat("ProductWeight"),
                rrs.getFloat("ProductStock"),
                rrs.getString("ProductSKU"),
                rrs.getString( "ProductName"),
                rrs.getString( "ProductCartDesc"),
                rrs.getString( "ProductShortDesc"),
                rrs.getString( "ProductLongDesc"),
                rrs.getString( "ProductThumb"),
                rrs.getString( "ProductImage"),
                rrs.getString( "ProductUpdateDate"),
                rrs.getString( "ProductLocation")
            );
        } catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return result;
    }

    private ProductBean sendRequest(String query, String type) {
        try {
            switch (type) {
                case "selectProducts":
                    ResultSet rrs = new MySQLHelper().sendSelectSQLRequest(query);

                    while (rrs.next()) {
                        System.out.println(rrs);
                    }

                    return new ProductBean(0, 0, 0, 0, 0, 0, 0, "", "", "", "", "", "", "", "", "");

                case "selectProduct":
                    break;

                case "saveProduct":
                    int irs = new MySQLHelper().sendUpdateSQLRequest(query);

                    if (irs != 0) {
                        return sendRequest("SELECT * FROM Info;", "select");
                    }
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return new ProductBean(0, 0, 0, 0, 0, 0, 0, "", "", "", "", "", "", "", "", "");
    }
}
