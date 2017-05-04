package com.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

/**
 * Created by xxx on 2017/5/4.
 */
public class Favorite extends Model<Favorite> {
    public final static Favorite dao = new Favorite();

    /**
     * 检测当前用户是否已经将此产品关注
     * @param createBy 当前用户
     * @param productId 产品
     * @return
     */
    public boolean isExistFavorite(String createBy, String productId) {
        String sql = "SELECT EXISTS(SELECT * FROM favorite where createBy=" + createBy + " and productId=" + productId+")";
        return 1 == (Db.queryLong(sql));
    }
}
