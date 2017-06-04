package com.pojo;

/**
 * 产品类型
 * Created by xxx on 2017/4/26.
 */
public enum  ProductType {
    bed(1,"bed"),
    sofa(2,"sofa"),
    desk(2,"desk"),
    group(2,"group"),
    other(2,"other");

    private int type;
    private String text;

    private ProductType(int type, String text){
        this.type = type;
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
