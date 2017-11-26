package cn.tommyyang.erweimastore.dao;

import cn.tommyyang.erweimastore.model.Product;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/26.
 */
public interface IProductDao {

    List<Product> get();

    Boolean add(Product product);
}
