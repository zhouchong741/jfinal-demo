package com.demo.controller;

import com.demo.interceptor.AdminInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;
import com.model.*;
import com.pojo.UserType;

import java.util.List;

/**
 * 用户登陆 Controller
 * Created by zc741 on 2017/5/6.
 */
public class AdminController extends BaseController {

    @Before(AdminInterceptor.class)
    public void index() {
        int pageSize = getParaToInt("pageSize", 10);
        int pageNumber = getParaToInt("pageNumber", 1);
        Page<Image> page = Image.dao.homePage(pageNumber, pageSize);
        setAttr("page", page);
        render("/admin/home/dashboard.html");
    }

    @Before(AdminInterceptor.class)
    public void productManage() {
        int pageSize = getParaToInt("pageSize", 10);
        int pageNumber = getParaToInt("pageNumber", 1);
        Page<Product> page = Product.dao.productPage(pageNumber, pageSize);
        setAttr("page", page);
        render("/admin/product/product-list.html");
    }

    @Before(AdminInterceptor.class)
    public void addProduct() {
        render("/admin/product/add-product.html");
    }

    @Before(AdminInterceptor.class)
    public void messageManage() {
        int pageSize = getParaToInt("pageSize", 10);
        int pageNumber = getParaToInt("pageNumber", 1);
        Page<Message> page = Message.dao.messagePage(pageNumber, pageSize);
        setAttr("page", page);
        render("/admin/message/message.html");
    }

    @Before(AdminInterceptor.class)
    public void statisticsManage() {
        int month = getParaToInt("month", 1);
        List<Sales> sales = Sales.dao.getSales(1);
        setAttr("sales", sales);
        render("/admin/statistics/statistics.html");
    }

    // 登录
    public void login() {
        render("/admin/login/login.html");
    }

    // login check
    public void loginCheck() {
        User user = new User();
        String userName = getPara("userName");
        String password = getPara("password");
        setSessionAttr("userName", userName);
        setSessionAttr("password", password);
        boolean info = user.isExist(userName, password, UserType.admin);
        if (info) {
            renderText("1");
        } else {
            renderText("0");
        }
    }

    // login out
    public void logout() {
        removeSessionAttr("userName");
        System.out.println((String) getSession().getAttribute("userName"));
        renderText("1");
    }

    // 上传产品
    public void uploadProduct() {
        Product info = getModel(Product.class, "");
        String now = getNow();
        info.set("createTime", now);
        info.save();
        renderText("1");
    }

    // change message status
    public void changeStatus() {
        String messageId = getPara("id");
        String excute = Message.dao.changeMessageStatus(messageId);
        renderText(excute);
    }

    // update product
    public void updateProduct() {
        int productId = getParaToInt("productId");
        Product product = Product.dao.getProduct(productId);
        setAttr("product", product);
        render("/admin/product/update-product.html");
    }

    // ajax update product
    public void updateProductItem() {
        int productId = getParaToInt("productId");
        String productName = getPara("productName");
        String price = getPara("price");
        String brand = getPara("brand");
        String itemNumber = getPara("itemNumber");
        String introduce = getPara("introduce");
        String length = getPara("length");
        String width = getPara("width");
        String height = getPara("height");
        String type = getPara("type");
        String headImage = getPara("headImage");
        String content = getPara("content");
        String excute = Product.dao.updateProductItem(productName, price, brand, itemNumber, introduce, length, width, height, type, headImage, content, productId);
        renderText(excute);
    }

    // update home product
    public void updateHome() {
        int id = getParaToInt("id");
        Image image = Image.dao.getHomeImage(id);
        setAttr("image", image);
        render("/admin/home/update-image.html");
    }

    // ajax update home
    public void updateHomeItem() {
        int id = getParaToInt("id");
        String imgName = getPara("imgName");
        String price = getPara("price");
        String introduce = getPara("introduce");
        String linkUrl = getPara("linkUrl");
        String type = getPara("type");
        String imgUrl = getPara("imgUrl");
        String excute = Image.dao.updateHomeItem(imgName, price, introduce, linkUrl, type, imgUrl, id);
        renderText(excute);
    }

    // ajax delete product
    public void deleteProductItem() {
        int productId = getParaToInt("productId");
        String excute = Product.dao.deleteProductItem(productId);
        renderText(excute);
    }
}
