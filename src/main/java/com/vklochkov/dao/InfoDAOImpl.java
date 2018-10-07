package com.vklochkov.dao;

import com.vklochkov.ds.InfoDS;
import com.vklochkov.model.Info;

public class InfoDAOImpl implements InfoDAO {
    private final InfoDS infoDS;

    public InfoDAOImpl() {
        this.infoDS = new InfoDS();
    }

    @Override
    public Info getInfo () {
        return this.infoDS.getInfo();
    }

    @Override
    public void saveInfo (Info info) {

    }
}
