package com.vklochkov.dao;

import com.vklochkov.bean.ProductBean;
import com.vklochkov.ds.ProductDS;

import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO {
    private final ProductDS productDS;

    public ProductDAOImpl (ProductDS productDS) {
        this.productDS = productDS;
    }

    @Override
    public ArrayList<ProductBean> getProducts() {
        return this.productDS.getProducts();
    }

    @Override
    public ProductBean getProductById(int id) {
        return this.productDS.getProduct(id);
    }

    @Override
    public ProductBean saveProductById(int id, ProductBean product) {
        return null;
    }
}
