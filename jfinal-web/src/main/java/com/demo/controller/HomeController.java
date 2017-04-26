package com.demo.controller;

import com.model.Image;
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
        List<Image> news = Image.dao.getNews(ImageType.news);
        setAttr("news", news);
        List<Image> hots = Image.dao.gethot(ImageType.hot);
        setAttr("hots",hots);
        if (isMobile) {
            render("/mobile/home/home.html");
        } else {
            render("/pc/home/home.html");
        }
    }
}
