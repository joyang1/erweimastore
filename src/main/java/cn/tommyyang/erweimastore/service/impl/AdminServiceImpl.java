package cn.tommyyang.erweimastore.service.impl;

import cn.tommyyang.erweimastore.dao.IAdminDao;
import cn.tommyyang.erweimastore.model.Admin;
import cn.tommyyang.erweimastore.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by TommyYang on 2017/11/21.
 */

@Service
public class AdminServiceImpl implements IAdminService {

    private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    @Qualifier("adminDao")
    private IAdminDao adminDao;

    @Override
    public Admin checkAdmin(String name, String passwd) {
        Admin admin = new Admin(name, passwd);
        try {
            return adminDao.checkAdmin(admin);
        } catch (Exception e) {
            logger.error("check admin error:\n", e);
        }
        return null;
    }

}
