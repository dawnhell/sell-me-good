package com.vklochkov.soap;

import com.vklochkov.dao.InfoDAOImpl;
import com.vklochkov.model.Info;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;

@WebService(
    endpointInterface = "com.vklochkov.soap.ShopInfo",
    targetNamespace = "http://sellmegood.com",
    serviceName = "ShopInfoService",
    portName = "ShopInfoPort"
)
@SOAPBinding(
    style = SOAPBinding.Style.RPC
)
public class ShopInfoImpl implements ShopInfo {
    private InfoDAOImpl infoDAO;

    public ShopInfoImpl() throws SQLException {
        this.infoDAO = new InfoDAOImpl();
    }

    @Override
    public Info getShopInfo() {
        return this.infoDAO.getInfo();
    }
}
