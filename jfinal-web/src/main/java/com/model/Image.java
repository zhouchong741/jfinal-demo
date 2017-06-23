package com.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.pojo.ImageType;

import java.util.List;

/**
 * 图片 Model
 * Created by zc741 on 2017/4/23.
 */
public class Image extends Model<Image> {
    public final static Image dao = new Image();

    /**
     * banner 图
     *
     * @param type
     * @return
     */
    public List<Image> getBanner(ImageType type) {
        String sql = "SELECT * FROM image WHERE type='" + type + "'";
        return dao.find(sql);
    }

    /**
     * discount 图
     *
     * @param type
     * @return
     */
    public List<Image> getDiscount(ImageType type) {
        String sql = "SELECT * FROM image WHERE type='" + type + "'";
        return dao.find(sql);
    }

    /**
     * news
     *
     * @param type
     * @return
     */
    public List<Image> getNews(ImageType type) {
        String sql = "SELECT * FROM image WHERE type='" + type + "'";
        return dao.find(sql);
    }

    /**
     * hot
     *
     * @param type
     * @return
     */
    public List<Image> getHot(ImageType type) {
        String sql = "SELECT * FROM image WHERE type='" + type + "'";
        return dao.find(sql);
    }

    /**
     * 全部首页产品
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public Page<Image> homePage(int pageNumber, int pageSize) {
        String select = "SELECT * ";
        String where = " FROM image ORDER BY type";
        Page<Image> page = dao.paginate(pageNumber, pageSize, select, where);
        return page;
    }

    /**
     * 具体某一个产品
     *
     * @param id
     * @return
     */
    public Image getHomeImage(int id) {
        String sql = "SELECT * FROM image where id=" + id;
        return dao.findFirst(sql);
    }

    public String updateHomeItem(String imgName, String price, String introduce, String linkUrl, String type, String imgUrl, int id) {
        String sql = "UPDATE image SET imgName='" + imgName + "', price=" + price + " ,introduce='" + introduce +
                "', type='" + type + "', imgUrl='" + imgUrl + "', linkUrl='" + linkUrl + "' WHERE id=" + id;
        Db.update(sql);
        return "1";
    }
}
