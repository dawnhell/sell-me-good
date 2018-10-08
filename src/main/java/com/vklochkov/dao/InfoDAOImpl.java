package com.vklochkov.dao;

import com.vklochkov.ds.InfoDS;
import com.vklochkov.model.Info;

public class InfoDAOImpl implements InfoDAO {
    private final InfoDS infoDS;

    public InfoDAOImpl (InfoDS infoDs) {
        this.infoDS = infoDs;
    }

    @Override
    public Info getInfo () {
        return this.infoDS.getInfo();
    }

    @Override
    public Info saveInfo (Info info) {
        return this.infoDS.saveInfo(info);
    }
}
