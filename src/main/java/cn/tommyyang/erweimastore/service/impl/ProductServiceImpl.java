package cn.tommyyang.erweimastore.service.impl;

import cn.tommyyang.erweimastore.dao.IProductDao;
import cn.tommyyang.erweimastore.model.Product;
import cn.tommyyang.erweimastore.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/26.
 */
@Service
public class ProductServiceImpl implements IProductService {

    private final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    @Qualifier("productDao")
    private IProductDao productDao;

    @Override
    public List<Product> get() {
        try {
            return productDao.get();
        }catch (Exception e){
            logger.error("get all product:\n", e);
        }
        return null;
    }

    @Override
    public Product getOne(String name) {
        try {
            return productDao.getOne(name);
        }catch (Exception e){
            logger.error(String.format("get one product by name=%s:\n",name), e);
        }
        return null;
    }

    @Override
    public Boolean add(String name, float price, float percent, String picturePath, Integer storeid) {
        try {
            Product existProduct = productDao.getOne(name);
            Product product = new Product(name, picturePath, price, percent, storeid);
            if(existProduct == null){
                return productDao.add(product);
            }else {
                productDao.update(product);
                return true;
            }
        } catch (Exception e) {
            logger.error("add product error:\n", e);
        }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            productDao.delete(id);
            return true;
        } catch (Exception e) {
            logger.error("add product error:\n", e);
        }
        return false;
    }
}
