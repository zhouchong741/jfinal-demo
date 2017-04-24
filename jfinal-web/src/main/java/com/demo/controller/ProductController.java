package com.demo.controller;

import com.jfinal.core.Controller;
import com.model.Product;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class ProductController extends Controller {
    public void index() {
        List<Product> products = Product.dao.getProducts();
        setAttr("products", products);
        render("/product/product.html");
    }
}
