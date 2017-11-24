package cn.tommyyang.erweimastore.dao;

import cn.tommyyang.erweimastore.model.Store;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/24.
 */
public interface IStoreDao {

    void add(Store store);

    List<Store> get();

    Boolean delete(Integer id);

}
