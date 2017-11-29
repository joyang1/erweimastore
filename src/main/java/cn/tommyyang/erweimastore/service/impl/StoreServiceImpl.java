package cn.tommyyang.erweimastore.service.impl;

import cn.tommyyang.erweimastore.dao.IStoreDao;
import cn.tommyyang.erweimastore.model.Store;
import cn.tommyyang.erweimastore.service.IStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TommyYang on 2017/11/24.
 */
@Service
public class StoreServiceImpl implements IStoreService {

    private final static Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    @Qualifier("storeDao")
    private IStoreDao storeDao;

    @Override
    public void add(String name) {
        Store store = new Store();
        store.setName(name);
        try {
            storeDao.add(store);
        }catch (Exception e){
            logger.error("add store error:\n", e);
        }
    }

    @Override
    public List<Store> get() {
        try {
            return storeDao.get();
        }catch (Exception e){
            logger.error("get all store error:\n", e);
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            return storeDao.delete(id);
        }catch (Exception e){
            logger.error("delete store error:\n", e);
        }
        return false;
    }

    @Override
    public Map<Integer, Store> getMap() {
        try{
            List<Store> stores = storeDao.get();
            Map<Integer, Store> map = new HashMap<Integer, Store>();
            for (Store store:stores) {
                map.put(store.getId(), store);
            }
            return map;
        }catch (Exception e){
            logger.error("get store map error:\n", e);
        }

        return null;
    }
}
