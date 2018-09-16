import business.ProductServiceImpl;
import model.Product;

import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(
    endpointInterface = "ProductCatalog",
    targetNamespace = "http://sellmegood.com",
    serviceName = "ProductCatalogService",
    portName = "ProductCatalogPort"
)
public class ProductCatalogImpl implements ProductCatalog {
    private ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public List<String> getProductCategories() {
        return productService.getProductCategories();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productService.getProductsByCategory(category);
    }

    @Override
    public boolean addProduct(String category, String product) {
        return productService.addProduct(category, product);
    }
}
