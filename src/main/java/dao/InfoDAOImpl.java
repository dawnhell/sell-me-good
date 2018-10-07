package dao;

import ds.InfoDS;
import model.Info;

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
