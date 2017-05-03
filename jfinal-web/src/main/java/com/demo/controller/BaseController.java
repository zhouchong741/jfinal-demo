package com.demo.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.utils.DateFormatUtils;
import com.utils.DateUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by xxx on 2017/4/25.
 */
public class BaseController extends Controller {
    protected String getNow() {
        return DateUtils.getNow(DateFormatUtils.DEFAULT_YYYY_MM_DD_HH_MIN_SS);
    }

    protected String getNYR(){
        return DateUtils.getNYR(DateFormatUtils.DEFAULT_YYYY_MM_DD);
    }


    public boolean isMobile() {

        boolean mobile = false;
        String userAgent = getRequest().getHeader("User-Agent");
        if (StrKit.notBlank(userAgent)) {
            Pattern p = Pattern.compile("Android|iPhone|SymbianOS|Windows Phone|iPod");
            Matcher m = p.matcher(userAgent);
            mobile = m.find();
        }
        return mobile;
    }
}
