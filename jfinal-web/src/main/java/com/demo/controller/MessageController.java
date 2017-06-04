package com.demo.controller;

import com.model.Message;

/**
 * 留言
 * Created by xxx on 2017/4/28.
 */
public class MessageController extends BaseController {
    public void index() {
        boolean isMobile = isMobile();
        if (isMobile) {
            render("/mobile/message/message.html");
        } else {
            render("/pc/message/message.html");
        }
    }

    public void messageSubmit() {
        Message info = getModel(Message.class, "");
        String now = getNow();
        info.set("createTime",now);
        info.save();
        renderText("ok");
    }
}
