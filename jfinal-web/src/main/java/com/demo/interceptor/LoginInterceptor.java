package com.demo.interceptor;

import com.demo.controller.BaseController;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

import javax.servlet.http.HttpSession;

/**
 * Created by xxx on 2017/5/3.
 */
public class LoginInterceptor extends BaseController implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        HttpSession session = inv.getController().getSession();
        if (session != null) {
            String phoneNumber = (String) session.getAttribute("phoneNumber");
            if (phoneNumber == null || phoneNumber.isEmpty()) {
                // 跳转到登录页面
                inv.getController().redirect("/user/login");
            } else {
                inv.invoke();
                System.out.println("========OK========");
            }
        } else {
            inv.getController().redirect("/user/login");
        }
    }
}
