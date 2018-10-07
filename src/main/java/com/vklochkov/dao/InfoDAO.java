package com.vklochkov.dao;

import com.vklochkov.model.Info;

public interface InfoDAO {
    public Info getInfo();

    public void saveInfo(Info info);
}
