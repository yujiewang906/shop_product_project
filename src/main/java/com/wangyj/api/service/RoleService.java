package com.wangyj.api.service;


import com.wangyj.api.model.po.ShopRole;

import java.util.List;

public interface RoleService {


    List<ShopRole> queryData();


    void addRole(ShopRole role);


    void updateRole(ShopRole role);

    void deleteRole(Integer id);

}
