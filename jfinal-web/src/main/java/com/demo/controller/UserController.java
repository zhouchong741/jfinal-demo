package com.demo.controller;

import com.jfinal.core.Controller;
import come.model.User;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class UserController extends Controller {
    public void index(){
        List<User> count = User.me.count();
        setAttr("count",count);
        System.out.println(count);
        render("/view/user/user.jsp");
    }

    public void saveUser(){
        User user = getModel(User.class,"");
        user.put("createtime","2017-12-1");
        user.save();
        renderText("ok");
    }
}
