package dao;

import model.Info;

public interface InfoDAO {
    public Info getInfo();

    public void saveInfo(Info info);
}
