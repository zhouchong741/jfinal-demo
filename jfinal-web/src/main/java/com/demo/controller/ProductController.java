package com.demo.controller;

import com.model.Product;
import com.pojo.ProductType;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class ProductController extends BaseController {
    public void index() {
        boolean isMobile = isMobile();
        List<Product> chairs = Product.dao.getProducts(ProductType.chair);
        setAttr("chairs", chairs);
        List<Product> sofas = Product.dao.getSofas(ProductType.sofa);
        setAttr("sofas", sofas);
        if (isMobile){
            render("/pc/product/product.html");
        }else {
            render("/mobile/product/product.html");
        }
    }
}
