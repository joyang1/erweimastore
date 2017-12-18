package cn.tommyyang.erweimastore.dao;

import cn.tommyyang.erweimastore.model.Product;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/26.
 */
public interface IProductDao {

    List<Product> get();

    List<Product> get(Integer storeid);

    Product getOne(String name);

    void update(Product product);

    Boolean add(Product product);

    void delete(Integer id);
}
