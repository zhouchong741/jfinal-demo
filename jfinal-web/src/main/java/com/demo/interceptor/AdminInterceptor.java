package com.demo.interceptor;

import com.demo.controller.BaseController;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

import javax.servlet.http.HttpSession;

/**
 * Created by zc741 on 2017/5/6.
 */
public class AdminInterceptor extends BaseController implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        HttpSession session = inv.getController().getSession();
        if (session != null) {
            String userName = (String) session.getAttribute("userName");
            if (userName == null || userName.isEmpty()) {
                // 跳转到登录页面
                inv.getController().redirect("/admin/login");
            } else {
                inv.invoke();
                System.out.println("========OK========");
            }
        } else {
            inv.getController().redirect("/admin/login");
        }
    }
}
