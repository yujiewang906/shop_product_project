package com.wangyj.api.service.impl;

import com.wangyj.api.dao.PermissionDao;
import com.wangyj.api.model.po.Permission;
import com.wangyj.api.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;


    @Override
    public List<Permission> selectPermission() {

        List<Permission> permissions = permissionDao.selectPermission();

        return permissions;
    }

    @Override
    public void addPermission(Permission permission) {

        permissionDao.addPermission(permission);

    }

    @Override
    public void updatePermission(Permission permission) {

        permissionDao.updatePermission(permission);

    }

    @Override
    public void deletePermission(Integer id) {

        permissionDao.deletePermission(id);

    }
}
