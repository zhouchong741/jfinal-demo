package com.demo.controller;

import com.model.Image;
import com.model.Product;
import com.pojo.ImageType;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class HomeController extends BaseController {
    public void index() {
        boolean isMobile = isMobile();
        List<Image> banners = Image.dao.getBanner(ImageType.banner);
        setAttr("banners", banners);
        List<Image> discounts = Image.dao.getDiscount(ImageType.discount);
        setAttr("discounts", discounts);
        List<Product> products = Product.dao.getProducts();
        setAttr("products", products);
        if (isMobile) {
            render("/mobile/home/home.html");
        } else {
            render("/pc/home/home.html");
        }
    }
}
