
package ws.productCatalog;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sellmegood package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProductsByCategory_QNAME = new QName("http://sellmegood.com", "getProductsByCategory");
    private final static QName _GetProductsByCategoryResponse_QNAME = new QName("http://sellmegood.com", "getProductsByCategoryResponse");
    private final static QName _Product_QNAME = new QName("http://sellmegood.com", "Product");
    private final static QName _AddProductResponse_QNAME = new QName("http://sellmegood.com", "addProductResponse");
    private final static QName _GetProductCategories_QNAME = new QName("http://sellmegood.com", "getProductCategories");
    private final static QName _GetProductCategoriesResponse_QNAME = new QName("http://sellmegood.com", "getProductCategoriesResponse");
    private final static QName _AddProduct_QNAME = new QName("http://sellmegood.com", "addProduct");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sellmegood
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddProduct }
     * 
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link GetProductCategories }
     * 
     */
    public GetProductCategories createGetProductCategories() {
        return new GetProductCategories();
    }

    /**
     * Create an instance of {@link GetProductCategoriesResponse }
     * 
     */
    public GetProductCategoriesResponse createGetProductCategoriesResponse() {
        return new GetProductCategoriesResponse();
    }

    /**
     * Create an instance of {@link GetProductsByCategory }
     * 
     */
    public GetProductsByCategory createGetProductsByCategory() {
        return new GetProductsByCategory();
    }

    /**
     * Create an instance of {@link GetProductsByCategoryResponse }
     * 
     */
    public GetProductsByCategoryResponse createGetProductsByCategoryResponse() {
        return new GetProductsByCategoryResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsByCategory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sellmegood.com", name = "getProductsByCategory")
    public JAXBElement<GetProductsByCategory> createGetProductsByCategory(GetProductsByCategory value) {
        return new JAXBElement<GetProductsByCategory>(_GetProductsByCategory_QNAME, GetProductsByCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsByCategoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sellmegood.com", name = "getProductsByCategoryResponse")
    public JAXBElement<GetProductsByCategoryResponse> createGetProductsByCategoryResponse(GetProductsByCategoryResponse value) {
        return new JAXBElement<GetProductsByCategoryResponse>(_GetProductsByCategoryResponse_QNAME, GetProductsByCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sellmegood.com", name = "Product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sellmegood.com", name = "addProductResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductCategories }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sellmegood.com", name = "getProductCategories")
    public JAXBElement<GetProductCategories> createGetProductCategories(GetProductCategories value) {
        return new JAXBElement<GetProductCategories>(_GetProductCategories_QNAME, GetProductCategories.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductCategoriesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sellmegood.com", name = "getProductCategoriesResponse")
    public JAXBElement<GetProductCategoriesResponse> createGetProductCategoriesResponse(GetProductCategoriesResponse value) {
        return new JAXBElement<GetProductCategoriesResponse>(_GetProductCategoriesResponse_QNAME, GetProductCategoriesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sellmegood.com", name = "addProduct")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

}
