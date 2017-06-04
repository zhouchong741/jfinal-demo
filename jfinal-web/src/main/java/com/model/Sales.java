package com.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * 后台管理分析 销售情况 未定
 * Created by xxx on 2017/5/9.
 */
public class Sales extends Model<Sales> {
    public final static Sales dao = new Sales();

    /**
     * 销售情况
     *
     * @param month
     * @return
     */
    public List<Sales> getSales(int month) {
        String sql = "SELECT * FROM sales where month=" + month;
        return dao.find(sql);
    }
}
