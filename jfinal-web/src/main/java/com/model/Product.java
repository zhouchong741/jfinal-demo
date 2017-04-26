package com.model;

import com.jfinal.plugin.activerecord.Model;
import com.pojo.ProductType;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class Product extends Model<Product> {
    public final static Product dao = new Product();

    public List<Product> getChairs(ProductType type) {
        String sql = "SELECT * FROM product where type='" + type + "' ORDER BY createTime DESC limit 8";
        return dao.find(sql);
    }

    public List<Product> getSofas(ProductType type) {
        String sql = "SELECT * FROM product where type='" + type + "' ORDER BY createTime DESC limit 8";
        return dao.find(sql);
    }

    /**
     * 具体某一个产品
     *
     * @param productId
     * @return
     */
    public Product getProduct(int productId) {
        String sql = "SELECT * FROM product where productId=" + productId;
        return dao.findFirst(sql);
    }

    public List<Product> getRecommends(int productId) {
        String sql = "SELECT * FROM product where not productId=" + productId + " ORDER BY createTime DESC limit 4";
        return dao.find(sql);
    }
}
