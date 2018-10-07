package com.vklochkov.soap;

import com.vklochkov.business.ProductServiceImpl;
import com.vklochkov.model.Product;

import javax.jws.WebService;
import java.util.List;

@WebService(
    endpointInterface = "com.vklochkov.soap.ProductCatalog",
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
