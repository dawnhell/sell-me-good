package com.vklochkov.dao;

import com.vklochkov.bean.ProductBean;

import java.util.ArrayList;

public interface ProductDAO {
    public ArrayList<ProductBean> getProducts ();

    public ProductBean getProductById (int id);

    public ProductBean saveProductById (int id, ProductBean product);
}
