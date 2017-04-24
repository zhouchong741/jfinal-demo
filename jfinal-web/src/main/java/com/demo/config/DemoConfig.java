package com.demo.config;

import com.demo.controller.ProductController;
import com.demo.controller.HomeController;
import com.demo.controller.UserController;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.model._MappingKit;
import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal.BeetlRenderFactory;

/**
 * Created by zc741 on 2017/4/22.
 */
public class DemoConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        //读取数据库配置文件
        PropKit.use("config.properties");
        me.setMainRenderFactory(new BeetlRenderFactory(PathKit.getWebRootPath() + "/WEB-INF/beetl"));
        GroupTemplate gt = BeetlRenderFactory.groupTemplate;
        //me.setViewType(ViewType.JSP);
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/home",HomeController.class);
        me.add("/product",ProductController.class);
        me.add("/user",UserController.class);
    }

    @Override
    public void configPlugin(Plugins me) {
        //配置数据库连接池插件
        C3p0Plugin c3p0Plugin=new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("username"), PropKit.get("password"));
        me.add(c3p0Plugin);

        ActiveRecordPlugin arp=new ActiveRecordPlugin(c3p0Plugin);
        me.add(arp);

        //arp.addMapping("user",Image.class);
        _MappingKit.mapping(arp);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("ctx"));
    }
}
