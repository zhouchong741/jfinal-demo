package com.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * 喜欢产品 Model
 * Created by xxx on 2017/5/4.
 */
public class Favorite extends Model<Favorite> {
    public final static Favorite dao = new Favorite();

    /**
     * 检测当前用户是否已经将此产品关注
     *
     * @param createBy  当前用户
     * @param productId 产品
     * @return 结果
     */
    public boolean isExistFavorite(String createBy, String productId) {
        String sql = "SELECT EXISTS(SELECT * FROM favorite where createBy=" + createBy + " and productId=" + productId + ")";
        return 1 == (Db.queryLong(sql));
    }

    /**
     * 根据手机号查询关注的产品列表
     *
     * @param phoneNumber
     * @return
     */
    public List<Favorite> getFavorite(String phoneNumber) {
        String sql = "SELECT a.createBy, b.* FROM favorite a, product b WHERE a.productId = b.productId AND createBy=" + phoneNumber;
        return dao.find(sql);
    }
}
