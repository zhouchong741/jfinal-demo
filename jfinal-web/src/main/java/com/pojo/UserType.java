package com.pojo;

/**
 * Created by zc741 on 2017/5/6.
 */
public enum UserType {
    admin(1, "admin");
    private int type;
    private String text;

    UserType(int type, String admin) {
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
