
package ws_generated.shopInfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ShopInfoImpl", targetNamespace = "http://sellmegood.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ShopInfoImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws InvalidInputException_Exception
     */
    @WebMethod(action = "get_shop_info")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getShopInfo", targetNamespace = "http://sellmegood.com", className = "GetShopInfo")
    @ResponseWrapper(localName = "getShopInfoResponse", targetNamespace = "http://sellmegood.com", className = "GetShopInfoResponse")
    @Action(input = "get_shop_info", output = "http://sellmegood.com/ShopInfoImpl/getShopInfoResponse", fault = {
        @FaultAction(className = InvalidInputException_Exception.class, value = "http://sellmegood.com/ShopInfoImpl/getShopInfo/Fault/InvalidInputException")
    })
    public String getShopInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws InvalidInputException_Exception
    ;

}