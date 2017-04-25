package com.demo.controller;

import com.model.User;

/**
 * Created by xxx on 2017/4/24.
 */
public class UserController extends BaseController {
    public void index(){
        render("/pc/user/user.html");
    }

    // login
    public void login(){
        User user = new User();
        String userName = getPara("userName");
        String password = getPara("password");
        boolean info = user.isExist(userName, password);
        if (info){
            renderText("1");
        }else {
            renderText("0");
        }
    }
}
