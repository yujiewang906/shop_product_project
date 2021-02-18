package com.wangyj.api.controller;

import com.wangyj.api.model.po.Permission;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;


    @GetMapping("selectPermission")
    public ResultData  selectPermission()
    {
        List<Permission> permissions = permissionService.selectPermission();

        return  ResultData.success(permissions);
    }

    @PostMapping("addPermission")
    public  ResultData   addPermission(Permission permission){

        permissionService.addPermission(permission);

        return  ResultData.success(null);
    }

    @PostMapping("updatePermission")
    public ResultData  updatePermission(Permission permission){

        permissionService.updatePermission(permission);

        return  ResultData.success(null);
    }

    @DeleteMapping("deletePermission")
    public  ResultData  deletePermission(Integer id){

        permissionService.deletePermission(id);

        return ResultData.success(null);
    }


}
