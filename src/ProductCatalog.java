import business.ProductServiceImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.ws.Endpoint;

import java.util.List;

@WebService(targetNamespace = "http://test")
public class ProductCatalog {
  private ProductServiceImpl productService = new ProductServiceImpl();

  @WebMethod
  public List<String> getProductCategories () {
    return productService.getProductCategories();
  }

  @WebMethod
  public List<String> getProductsByCategory (String category) {
    return productService.getProductsByCategory(category);
  }

  @WebMethod
  public boolean addProduct (String category, String product) {
    return productService.addProduct(category, product);
  }
}
