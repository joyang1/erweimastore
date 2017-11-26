package cn.tommyyang.erweimastore.dao.impl;

import cn.tommyyang.erweimastore.dao.BaseDao;
import cn.tommyyang.erweimastore.dao.IProductDao;
import cn.tommyyang.erweimastore.model.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/26.
 */
@Repository("productDao")
public class ProductDaoImpl extends BaseDao implements IProductDao {

    @Override
    public List<Product> get() {
        SqlSession session = this.getSqlSessionFactory().openSession();
        List<Product> products = session.selectList("cn.tommyyang.erweimastore.mapping.productMapping.selectAllProduct");
        session.commit();
        session.close();
        return products;
    }

    @Override
    public Boolean add(Product product) {
        SqlSession session = this.getSqlSessionFactory().openSession();
        int result = session.insert("cn.tommyyang.erweimastore.mapping.productMapping.addProduct");
        session.commit();
        session.close();
        return result > 0;
    }

}
