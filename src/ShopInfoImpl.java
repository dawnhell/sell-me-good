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
    @Override
    public String getShopInfo(String property) throws InvalidInputException {
        String response = null;

        if ("shopName".equals(property)) {
            response = "Sell Me Good";
        } else if ("foundationDate".equals(property)) {
            response = "September 2018";
        } else {
            throw new InvalidInputException("Invalid Input", property + " is not valid input.");
        }

        return response;
    }
}
