import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(
    targetNamespace = "http://sellmegood.com",
    name = "ShopInfoImpl"
)
public interface ShopInfo {
    @WebMethod(
        action = "get_shop_info",
        operationName = "getShopInfo"
    )
    @WebResult(
        partName = "shopInfo"
    )
    String getShopInfo (@WebParam(partName = "property") String property);
}
