package com.demo.controller;

import com.demo.interceptor.AdminInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;
import com.model.Message;
import com.model.User;
import com.pojo.UserType;

/**
 * Created by zc741 on 2017/5/6.
 */
public class AdminController extends BaseController {

    @Before(AdminInterceptor.class)
    public void index() {
        render("/admin/home/dashboard.html");
    }

    @Before(AdminInterceptor.class)
    public void productManage() {
        render("/admin/product/product.html");
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

    // change message status
    public void changeStatus(){
        String messageId = getPara("id");
        String excute = Message.dao.changeMessageStatus(messageId);
        renderText(excute);
    }
}
