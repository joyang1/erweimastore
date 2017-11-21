package cn.tommyyang.erweimastore.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

/**
 * Created by TommyYang on 2017/11/21.
 */
public class BaseDao {

    @Resource(name="sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    protected SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
