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
     * @param userName
     * @param password
     * @return
     */
    public boolean isExist(String userName, String password) {
        String sql = "SELECT EXISTS(select * from user where userName='" + userName + "' and password='" + password + "')";
        return 1 == (Db.queryLong(sql));
    }

    public boolean isExistPhoneNumber(String phoneNumber) {
        String sql = "SELECT EXISTS(select * from user where phoneNumber = " + phoneNumber + ")";
        return 1 == (Db.queryLong(sql));
    }
}
