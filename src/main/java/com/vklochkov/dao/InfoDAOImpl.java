package com.vklochkov.dao;

import com.vklochkov.ds.DBConnector;
import com.vklochkov.ds.InfoDS;
import com.vklochkov.model.Info;

import java.sql.Connection;
import java.sql.SQLException;

public class InfoDAOImpl implements InfoDAO {
    private final InfoDS infoDS;

    public InfoDAOImpl () throws SQLException {
        Connection connection = new DBConnector().getConnection();
        this.infoDS = new InfoDS(connection);
    }

    @Override
    public Info getInfo () {
        return this.infoDS.getInfo();
    }

    @Override
    public void saveInfo (Info info) {

    }
}
