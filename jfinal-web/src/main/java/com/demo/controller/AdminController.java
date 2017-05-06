package com.demo.controller;

/**
 * Created by zc741 on 2017/5/6.
 */
public class AdminController extends BaseController {
    public void index() {
        render("/admin/home/dashboard.html");
    }

    public void productManage(){
        render("/admin/product/product.html");
    }
    public void messageManage(){
        render("/admin/message/message.html");
    }
    public void statisticsManage(){
        render("/admin/statistics/statistics.html");
    }
}
