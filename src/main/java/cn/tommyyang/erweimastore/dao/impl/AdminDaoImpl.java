package cn.tommyyang.erweimastore.dao.impl;

import cn.tommyyang.erweimastore.dao.IAdminDao;
import cn.tommyyang.erweimastore.dao.BaseDao;
import cn.tommyyang.erweimastore.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by TommyYang on 2017/11/21.
 */
@Repository("adminDao")
public class AdminDaoImpl  extends BaseDao implements IAdminDao {

    @Override
    public Admin checkAdmin(Admin currentAdmin) {
        SqlSession session = this.getSqlSessionFactory().openSession();
        Admin admin = session.selectOne("cn.tommyyang.erweimastore.mapping.adminMapping.checkAdmin", currentAdmin);
        session.commit();
        session.close();
        return admin;
    }
}
