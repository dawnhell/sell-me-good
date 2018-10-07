import dao.InfoDAOImpl;
import model.Info;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(
    endpointInterface = "ShopInfo",
    targetNamespace = "http://sellmegood.com",
    serviceName = "ShopInfoService",
    portName = "ShopInfoPort"
)
@SOAPBinding(
    style = SOAPBinding.Style.RPC
)
public class ShopInfoImpl implements ShopInfo {
    private InfoDAOImpl infoDAO;

    public ShopInfoImpl() {
        this.infoDAO = new InfoDAOImpl();
    }

    @Override
    public Info getShopInfo() {
        return this.infoDAO.getInfo();
    }
}
