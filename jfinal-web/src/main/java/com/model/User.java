package com.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by xxx on 2017/4/24.
 */
public class User extends Model<User> {
    public final static User dao = new User();

    /**
     * 当前用户是否存在
     *
     * @param phoneNumber
     * @param password
     * @return
     */
    public boolean isExist(String phoneNumber, String password) {
        String sql = "SELECT EXISTS(select * from user where phoneNumber='" + phoneNumber + "' and password='" + password + "')";
        return 1 == (Db.queryLong(sql));
    }

    /**
     * 检测当前号码是否已经注册
     *
     * @param phoneNumber
     * @return
     */
    public boolean isExistPhoneNumber(String phoneNumber) {
        String sql = "SELECT EXISTS(select * from user where phoneNumber = " + phoneNumber + ")";
        return 1 == (Db.queryLong(sql));
    }

    /**
     * 检测当前用户名是否已经存在
     *
     * @param userName
     * @return
     */
    public boolean isExistUserName(String userName) {
        String sql = "SELECT EXISTS(select * from user where phoneNumber = " + userName + ")";
        return 1 == (Db.queryLong(sql));
    }

    /**
     * 根据手机号码查找个人信息
     *
     * @param phoneNumber
     * @return
     */
    public User getUserInfo(String phoneNumber) {
        String sql = "SELECT * FROM user where phoneNumber=" + phoneNumber;
        return dao.findFirst(sql);
    }

    /**
     * 更新个人信息
     * @param phoneNumber
     * @param userName
     * @param avatarUrl
     * @param address
     * @return
     */
    public String updateUser(String phoneNumber, String userName,String avatarUrl, String address) {
        String sql = "UPDATE user SET userName='" + userName + "',avatarUrl='" + avatarUrl + "',address='" + address + "' WHERE phoneNumber = '" + phoneNumber + "'";
        Db.update(sql);
        return "1";
    }
}
