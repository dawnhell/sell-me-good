import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(
    targetNamespace = "http://sellmegood.com",
    name = "ShopInfo",
    serviceName = "ShopInfoService",
    portName = "ShopInfoPort"
)
public class ShopInfo {
    @WebMethod(
        action = "get_shop_info",
        operationName = "getShopInfo"
    )
    public String getShopInfo (String property) {
        String response = "Invalid property!";

        if ("shopName".equals(property)) {
            response = "Sell Me Good";
        } else if ("foundationDate".equals(property)) {
            response = "September 2018";
        }

        return response;
    }
}
