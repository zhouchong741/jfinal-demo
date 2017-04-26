package com.pojo;

/**
 * Created by xxx on 2017/4/26.
 */
public enum  ProductType {
    chair(1,"chair"),
    sofa(2,"sofa");

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
