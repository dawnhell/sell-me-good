package com.vklochkov.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private String dbURL = "jdbc:mysql://localhost:3306/wsdb?user=root&password=root";
    private Connection connection;

    public DBConnector () throws SQLException {
        this.connection = DriverManager.getConnection(this.dbURL);
    }

    public Connection getConnection() {
        return connection;
    }
}
