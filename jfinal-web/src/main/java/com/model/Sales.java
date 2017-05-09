package com.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by xxx on 2017/5/9.
 */
public class Sales extends Model<Sales> {
    public final static Sales dao = new Sales();


    public List<Sales> getSales(int month) {
        String sql = "SELECT * FROM sales where month=" + month;
        return dao.find(sql);
    }
}
