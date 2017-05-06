package com.demo.controller;

import com.model.Product;
import com.utils.WechatUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by xxx on 2017/4/26.
 */
public class DetailController extends BaseController {

    public void index() {
        boolean isMobile = isMobile();
        int productId = getParaToInt("productId");
        Product product = Product.dao.getProduct(productId);
        setAttr("product", product);
        // 推荐产品不包含当前产品
        List<Product> recommends = Product.dao.getRecommends(productId);
        setAttr("recommends", recommends);

        HttpServletRequest request = getRequest();
        String url = ("http://" + request.getServerName() + request.getRequestURI() + "?productId=" + productId).split("#")[0];
        Map<String, String> map = WechatUtil.getJsConfig(url);
        setAttr("map", map);
        if (isMobile) {
            render("/mobile/detail/detail.html");
        } else {
            render("/pc/detail/detail.html");
        }
    }


}
