package com.vklochkov.soap;

import com.vklochkov.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(
    targetNamespace = "http://sellmegood.com",
    name = "com.vklochkov.soap.ProductCatalogImpl"
)
public interface ProductCatalog {
    @WebMethod(
        action = "get_product_categories",
        operationName = "getProductCategories"
    )
    @WebResult(
        name = "category"
    )
    List<String> getProductCategories();

    @WebMethod (
        action = "get_products_by_category",
        operationName = "getProductsByCategory"
    )
    @WebResult(
        name = "Product"
    )
    List<Product> getProductsByCategory(String category);

    @WebMethod (
        action = "add_product",
        operationName = "addProduct"
    )
    boolean addProduct(String category, String product);
}
