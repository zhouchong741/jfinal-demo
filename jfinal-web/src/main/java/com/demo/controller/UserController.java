package com.demo.controller;

import com.demo.interceptor.LoginInterceptor;
import com.jfinal.aop.Before;
import com.model.User;

/**
 * Created by xxx on 2017/4/24.
 */
public class UserController extends BaseController {

    public void index() {
        boolean isMobile = isMobile();
        if (isMobile) {
            render("/mobile/user/userCenter.html");
        } else {
            render("/pc/user/userCenter.html");
        }
    }

    // user center just for login interceptor
    @Before(LoginInterceptor.class)
    public void userCenter() {
        /*boolean isMobile = isMobile();
        if (isMobile) {
            render("/mobile/user/userCenter.html");
        } else {
            render("/pc/user/userCenter.html");
        }*/

        // do nothing
    }

    // user login
    public void login() {
        boolean isMobile = isMobile();
        if (isMobile) {
            render("/mobile/user/login.html");
        } else {
            render("/pc/user/login.html");
        }
    }

    // login check
    public void loginCheck() {
        User user = new User();
        String userName = getPara("userName");
        String password = getPara("password");
        setSessionAttr("userName", userName);
        setSessionAttr("password", password);
        boolean info = user.isExist(userName, password);
        if (info) {
            renderText("1");
        } else {
            renderText("0");
        }
    }

    // register
    public void register() {
        boolean isMobile = isMobile();
        if (isMobile) {
            render("/mobile/user/register.html");
        } else {
            render("/pc/user/register.html");
        }
    }

    // ajax register save
    public void registerSave() {
        String phoneNumber = getPara("phoneNumber");
        boolean isExistPhoneNumber = User.dao.isExistPhoneNumber(phoneNumber);
        if (!isExistPhoneNumber){
            User info = getModel(User.class, "");
            String now = getNow();
            info.set("createTime", now);
            info.save();
            renderText("1");
        }else {
            renderText("0");
        }
    }
}
