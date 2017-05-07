package com.model;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * Created by xxx on 2017/4/28.
 */
public class Message extends Model<Message> {
    public final static Message dao = new Message();

    /**
     * 留言信息分页
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public Page<Message> messagePage(int pageNumber, int pageSize) {
        String select = "SELECT * ";
        String where = " FROM message where `status`=0 ORDER BY createTime DESC ";
        Page<Message> page = dao.paginate(pageNumber, pageSize, select, where);
        return page;
    }

    public String changeMessageStatus(String messageId) {
        String sql = "UPDATE message SET status=1 WHERE id=" + messageId;
        Db.update(sql);
        return "1";
    }
}
