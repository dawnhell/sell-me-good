package dao;

import model.Info;

public class InfoDAOImpl implements InfoDAO {
//    private final DataSource dataSource;

    public InfoDAOImpl(/*DataSource dataSource*/) {
//        this.dataSource = dataSource;
    }

    @Override
    public Info getInfo () {
        return new Info();
    }

    @Override
    public void saveInfo (Info info) {

    }
}
