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
    public Product getOne(String name) {
        SqlSession session = this.getSqlSessionFactory().openSession();
        Product product = session.selectOne("cn.tommyyang.erweimastore.mapping.productMapping.selectProduct", name);
        session.commit();
        session.close();
        return product;
    }

    @Override
    public void update(Product product) {
        SqlSession session = this.getSqlSessionFactory().openSession();
        session.update("cn.tommyyang.erweimastore.mapping.productMapping.updateProductForInsert", product);
        session.commit();
        session.close();
    }

    @Override
    public Boolean add(Product product) {
        SqlSession session = this.getSqlSessionFactory().openSession();
        int result = session.insert("cn.tommyyang.erweimastore.mapping.productMapping.addProduct", product);
        session.commit();
        session.close();
        return result > 0;
    }

    @Override
    public void delete(Integer id) {
        SqlSession session = this.getSqlSessionFactory().openSession();
        int result = session.update("cn.tommyyang.erweimastore.mapping.productMapping.delProduct", id);
        session.commit();
        session.close();
    }

}
