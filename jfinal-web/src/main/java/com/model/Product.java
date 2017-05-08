package com.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.pojo.ProductType;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class Product extends Model<Product> {
    public final static Product dao = new Product();

    public List<Product> getBeds(ProductType type) {
        String sql = "SELECT * FROM product where type='" + type + "' ORDER BY createTime DESC limit 8";
        return dao.find(sql);
    }

    public List<Product> getSofas(ProductType type) {
        String sql = "SELECT * FROM product where type='" + type + "' ORDER BY createTime DESC limit 8";
        return dao.find(sql);
    }

    public List<Product> getDesks(ProductType type) {
        String sql = "SELECT * FROM product where type='" + type + "' ORDER BY createTime DESC limit 8";
        return dao.find(sql);
    }

    public List<Product> getGroups(ProductType type) {
        String sql = "SELECT * FROM product where type='" + type + "' ORDER BY createTime DESC limit 8";
        return dao.find(sql);
    }

    public List<Product> getOthers(ProductType type) {
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

    /**
     * 推荐产品
     *
     * @param productId
     * @return
     */
    public List<Product> getRecommends(int productId) {
        String sql = "SELECT * FROM product where not productId=" + productId + " ORDER BY createTime DESC limit 4";
        return dao.find(sql);
    }

    /**
     * 后台管理 产品列表 分页
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public Page<Product> productPage(int pageNumber, int pageSize) {
        String select = "SELECT * ";
        String where = " FROM product ORDER BY status DESC ";
        Page<Product> page = dao.paginate(pageNumber, pageSize, select, where);
        return page;
    }

    /**
     * 更新某个产品
     *
     * @param productName
     * @param price
     * @param brand
     * @param itemNumber
     * @param introduce
     * @param length
     * @param width
     * @param height
     * @param type
     * @param headImage
     * @param content
     * @param productId
     * @return
     */
    public String updateProductItem(String productName, String price, String brand, String itemNumber,
                                    String introduce, String length, String width, String height,
                                    String type, String headImage, String content, int productId) {
        String sql = "UPDATE product SET productName = '" + productName + "', price = " + price + ", " +
                "brand = '" + brand + "', itemNumber = " + itemNumber + ", introduce = '" + introduce + "', " +
                "length = " + length + ", width = " + width + ", height = " + height + ", type = '" + type + "', " +
                "headImage = '" + headImage + "', content = '" + content + "' WHERE productId = " + productId;
        Db.update(sql);
        return "1";
    }

    /**
     * 删除产品
     *
     * @param productId
     * @return
     */
    public String deleteProductItem(int productId) {
        String sql = "delete from product where productId = " + productId;
        Db.update(sql);
        return "1";
    }
}
