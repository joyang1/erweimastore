package cn.tommyyang.erweimastore.service;

import cn.tommyyang.erweimastore.model.Product;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/26.
 */
public interface IProductService {

    List<Product> get();

    List<Product> get(Integer storeid);

    Product getOne(String name);

    Boolean add(String name, float price, float percent, String picturePath, Integer storeid);

    Boolean delete(Integer id);

}
