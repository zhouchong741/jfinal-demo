package come.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class User extends Model<User> {
    public final static User me = new User();

    public List<User> count(){
        return find("select count(*) from user");
    }
}
