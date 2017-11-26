package cn.tommyyang.erweimastore.service;

import cn.tommyyang.erweimastore.model.Product;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/26.
 */
public interface IProductService {

    List<Product> get();

    Boolean add(String name, float price, float percent, String picturePath, String storeName);

}
