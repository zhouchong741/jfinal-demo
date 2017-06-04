package com.demo.interceptor;


import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * 验证 暂时无用
 * Created by xxx on 2017/5/3.
 */
public class LoginValidator extends Validator {
    @Override
    protected void validate(Controller c) {
        validateRequiredString("userName","nameMsg","请输入用户名");
        validateRequiredString("password","pwdMsg","请输入密码");
    }

    @Override
    protected void handleError(Controller c) {

    }
}
