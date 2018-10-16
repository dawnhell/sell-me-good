package com.vklochkov.resources;

import com.vklochkov.bean.ProductBean;
import com.vklochkov.dao.ProductDAO;
import com.vklochkov.dao.ProductDAOImpl;
import com.vklochkov.ds.ProductDS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/products")
public class ProductsResource {
    private ProductDAO productDAO;

    public ProductsResource () {
        this.productDAO = new ProductDAOImpl(new ProductDS());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ProductBean> getProducts () {
        return this.productDAO.getProducts();
    }
}
