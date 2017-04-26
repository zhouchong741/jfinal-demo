package com.demo.controller;

import com.model.Product;

/**
 * Created by xxx on 2017/4/26.
 */
public class DetailController extends BaseController {

    public void index() {
        boolean isMobile = isMobile();
        int productId = getParaToInt("productId");
        Product product = Product.dao.getProduct(productId);
        setAttr("product", product);
        if (isMobile) {
            render("/mobile/detail/detail.html");
        } else {
            render("/pc/detail/detail.html");
        }
    }


}
