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
    public Boolean add(String name, float price, float percent, String picturePath, String storeName) {
        try {
            Product product = new Product(name, picturePath, price, percent, storeName);
            return productDao.add(product);
        } catch (Exception e) {
            logger.error("add product error:\n", e);
        }
        return false;
    }
}
