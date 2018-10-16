package com.vklochkov.dao;

import com.vklochkov.bean.InfoBean;
import com.vklochkov.ds.InfoDS;

public class InfoDAOImpl implements InfoDAO {
    private final InfoDS infoDS;

    public InfoDAOImpl (InfoDS infoDs) {
        this.infoDS = infoDs;
    }

    @Override
    public InfoBean getInfo () {
        return this.infoDS.getInfo();
    }

    @Override
    public InfoBean saveInfo (InfoBean info) {
        return this.infoDS.saveInfo(info);
    }
}
