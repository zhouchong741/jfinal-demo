package com.model;

import com.jfinal.plugin.activerecord.Model;
import com.pojo.ProductType;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class Product extends Model<Product> {
    public final static Product dao = new Product();

    public List<Product> getProducts(ProductType type) {
        String sql = "SELECT * FROM product where type='" + type + "' ORDER BY createTime DESC limit 8";
        return dao.find(sql);
    }

    public List<Product> getSofas(ProductType type) {
        String sql = "SELECT * FROM product where type='" + type + "' ORDER BY createTime DESC limit 8";
        return dao.find(sql);
    }

    public Product getProduct(int productId) {
        String sql = "SELECT * FROM product where productId=" + productId;
        return dao.findFirst(sql);
    }
}
