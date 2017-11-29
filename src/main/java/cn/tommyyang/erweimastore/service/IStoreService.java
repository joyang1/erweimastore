package cn.tommyyang.erweimastore.service;

import cn.tommyyang.erweimastore.model.Store;

import java.util.List;
import java.util.Map;

/**
 * Created by TommyYang on 2017/11/24.
 */
public interface IStoreService {

    void add(String name);

    List<Store> get();

    Boolean delete(Integer id);

    Map<Integer, Store> getMap();

}
