package come.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Created by zc741 on 2017/4/23.
 */
public class _MappingKit {
    public static void mapping(ActiveRecordPlugin arp){
        arp.addMapping("user","username", User.class);
    }
}
