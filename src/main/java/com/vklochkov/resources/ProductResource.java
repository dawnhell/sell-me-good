package com.vklochkov.resources;

import com.vklochkov.bean.ProductBean;
import com.vklochkov.dao.ProductDAO;
import com.vklochkov.dao.ProductDAOImpl;
import com.vklochkov.ds.ProductDS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product")
public class ProductResource {
    private ProductDAO productDAO;

    public ProductResource () {
        this.productDAO = new ProductDAOImpl(new ProductDS());
    }

    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductBean getProduct (@PathParam("productId") int productId) {
        return this.productDAO.getProductById(productId);
    }
}
