package com.vklochkov.dao;

import com.vklochkov.bean.InfoBean;

public interface InfoDAO {
    public InfoBean getInfo();

    public InfoBean saveInfo(InfoBean info);
}
