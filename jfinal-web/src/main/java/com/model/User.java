package com.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by xxx on 2017/4/24.
 */
public class User extends Model<User> {
    public final static User dao = new User();

    public boolean isExist(String userName, String password) {
        String sql = "SELECT EXISTS(select * from user where userName='" + userName + "' and password='" + password + "')";
        return 1== (Db.queryLong(sql));
    }
}
