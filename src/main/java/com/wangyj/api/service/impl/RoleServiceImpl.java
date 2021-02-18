package com.wangyj.api.service.impl;

import com.wangyj.api.dao.RoleDao;
import com.wangyj.api.model.po.ShopRole;
import com.wangyj.api.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RoleServiceImpl  implements RoleService {

    @Resource
    private RoleDao  roleDao;


    @Override
    public List<ShopRole> queryData() {

        List<ShopRole> shopRoles = roleDao.queryData();


        return shopRoles;
    }

    @Override
    public void addRole(ShopRole role) {

        roleDao.addRole(role);

    }

    @Override
    public void updateRole(ShopRole role) {
        roleDao.upDateRole(role);
    }

    @Override
    public void deleteRole(Integer id) {
        roleDao.delteRole(id);
    }
}
