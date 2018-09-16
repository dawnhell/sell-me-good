import business.ProductServiceImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.List;

@WebService(
    targetNamespace = "http://sellmegood.com",
    name = "ProductCatalog",
    serviceName = "ProductCatalogService",
    portName = "ProductCatalogPort"
)
public class ProductCatalog {
    private ProductServiceImpl productService = new ProductServiceImpl();

    @WebMethod(
        action = "get_product_categories",
        operationName = "getProductCategories"
    )
    public List<String> getProductCategories () {
        return productService.getProductCategories();
    }

    @WebMethod(
        action = "get_products_by_category",
        operationName = "getProductsByCategory"
    )
    public List<String> getProductsByCategory (String category) {
        return productService.getProductsByCategory(category);
    }

    @WebMethod(
        action = "add_product",
        operationName = "addProduct"
    )
    public boolean addProduct (String category, String product) {
        return productService.addProduct(category, product);
    }
}
