import model.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(
    targetNamespace = "http://sellmegood.com",
    name = "ProductCatalogImpl"
)
public interface ProductCatalog {
    @WebMethod(
        action = "get_product_categories",
        operationName = "getProductCategories"
    )
    List<String> getProductCategories();

    @WebMethod (
        action = "get_products_by_category",
        operationName = "getProductsByCategory"
    )
    List<Product> getProductsByCategory(String category);

    @WebMethod (
        action = "add_product",
        operationName = "addProduct"
    )
    boolean addProduct(String category, String product);
}
