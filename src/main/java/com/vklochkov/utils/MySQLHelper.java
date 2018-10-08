package com.vklochkov.utils;

import com.vklochkov.ds.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLHelper {
    private Connection connection = null;
    private Statement stmt = null;

    public ResultSet sendSelectSQLRequest (String request) throws SQLException {
        this.connection = new DBConnector().getConnection();
        this.stmt = this.connection.createStatement();

        return this.stmt.executeQuery(request);
    }

    public int sendUpdateSQLRequest (String request) throws SQLException {
        this.connection = new DBConnector().getConnection();
        this.stmt = this.connection.createStatement();

        return this.stmt.executeUpdate(request);
    }
}
