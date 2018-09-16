import javax.jws.WebService;

@WebService(
    endpointInterface = "ShopInfo",
    targetNamespace = "http://sellmegood.com",
    serviceName = "ShopInfoService",
    portName = "ShopInfoPort"
)
public class ShopInfoImpl implements ShopInfo {
    @Override
    public String getShopInfo(String property) {
        String response = "Invalid property!";

        if ("shopName".equals(property)) {
            response = "Sell Me Good";
        } else if ("foundationDate".equals(property)) {
            response = "September 2018";
        }

        return response;
    }
}
