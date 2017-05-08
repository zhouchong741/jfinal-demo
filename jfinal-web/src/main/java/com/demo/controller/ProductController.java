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
        List<Product> beds = Product.dao.getBeds(ProductType.bed);
        setAttr("beds", beds);
        List<Product> sofas = Product.dao.getSofas(ProductType.sofa);
        setAttr("sofas", sofas);
        List<Product> desks = Product.dao.getDesks(ProductType.desk);
        setAttr("desks", desks);
        List<Product> groups = Product.dao.getGroups(ProductType.group);
        setAttr("groups", groups);
        List<Product> others = Product.dao.getOthers(ProductType.other);
        setAttr("others", others);
        if (isMobile) {
            render("/mobile/product/product.html");
        } else {
            render("/pc/product/product.html");
        }
    }
}
