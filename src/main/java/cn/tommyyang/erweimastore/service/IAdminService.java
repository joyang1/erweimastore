package cn.tommyyang.erweimastore.service;

import cn.tommyyang.erweimastore.model.Admin;

/**
 * Created by TommyYang on 2017/11/21.
 */
public interface IAdminService {

    Admin checkAdmin(String name, String passwd);

}
