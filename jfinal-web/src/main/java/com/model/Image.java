package com.model;

import com.pojo.ImageType;
import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 *
 * Created by zc741 on 2017/4/23.
 */
public class Image extends Model<Image> {
    public final static Image dao = new Image();

    /**
     * banner 图
     * @param type
     * @return
     */
    public List<Image> getBanner(ImageType type) {
        String sql = "SELECT * FROM image WHERE type='" + type + "'";
        return dao.find(sql);
    }

    /**
     * discount 图
     * @param type
     * @return
     */
    public List<Image> getDiscount(ImageType type){
        String sql = "SELECT * FROM image WHERE type='" + type + "'";
        return dao.find(sql);
    }
}
