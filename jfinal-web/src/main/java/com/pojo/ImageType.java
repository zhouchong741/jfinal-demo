package com.pojo;

/**
 * 图片类型
 * Created by zc741 on 2017/4/23.
 */
public enum  ImageType {
    discount(1,"discount"),
    banner(2,"banner"),
    news(3,"news"),
    hot(4,"hot");

    private int type;
    private String text;
    private ImageType(int type, String text){
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
