package com.wangyj.api.service;

import com.wangyj.api.model.po.Permission;

import java.util.List;

public interface PermissionService {


    List<Permission> selectPermission();

    void addPermission(Permission permission);

    void updatePermission(Permission permission);


    void deletePermission(Integer id);

}
