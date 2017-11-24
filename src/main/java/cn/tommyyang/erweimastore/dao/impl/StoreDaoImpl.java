package cn.tommyyang.erweimastore.dao.impl;

import cn.tommyyang.erweimastore.dao.BaseDao;
import cn.tommyyang.erweimastore.dao.IStoreDao;
import cn.tommyyang.erweimastore.model.Store;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/24.
 */
@Repository("storeDao")
public class StoreDaoImpl extends BaseDao implements IStoreDao {
    @Override
    public void add(Store store) {
        SqlSession session = this.getSqlSessionFactory().openSession();
        session.insert("cn.tommyyang.erweimastore.mapping.storeMapping.addStore", store);
        session.commit();
        session.close();
    }

    @Override
    public List<Store> get() {
        SqlSession session = this.getSqlSessionFactory().openSession();
        List<Store> stores = session.selectList("cn.tommyyang.erweimastore.mapping.storeMapping.selectAllStore");
        session.commit();
        session.close();
        return stores;
    }

    @Override
    public Boolean delete(Integer id) {
        SqlSession session = this.getSqlSessionFactory().openSession();
        Integer result = session.delete("cn.tommyyang.erweimastore.mapping.storeMapping.deleteStore", id);
        session.commit();
        session.close();
        return result > 0;
    }
}
