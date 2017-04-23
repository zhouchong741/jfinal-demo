package come.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by zc741 on 2017/4/23.
 */
public class Product extends Model<Product> {
    public final static Product dao = new Product();

    public List<Product> getProducts(){
        return find("SELECT * FROM product");
    }
}
