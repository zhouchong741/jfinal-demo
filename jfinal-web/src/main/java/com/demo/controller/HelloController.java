package com.demo.controller;

import com.jfinal.core.Controller;

/**
 * Created by zc741 on 2017/4/22.
 */
public class HelloController extends Controller {
    public void index(){
        //renderText("test");
        render("/test.html");
    }
}
