package com.demo.controller;

import com.pojo.ImageType;
import com.jfinal.core.Controller;
import com.model.Image;
import com.model.Product;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class HomeController extends Controller {
    public void index() {
        List<Image> banners = Image.dao.getBanner(ImageType.banner);
        setAttr("banners", banners);
        List<Product> products = Product.dao.getProducts();
        setAttr("products", products);
        render("/home/home.html");
    }
}
