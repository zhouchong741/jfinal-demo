package com.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Created by zc741 on 2017/4/23.
 */
public class _MappingKit {
    public static void mapping(ActiveRecordPlugin arp){
        arp.addMapping("image","id", Image.class);
        arp.addMapping("product","productId",Product.class);
    }
}
