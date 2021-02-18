package com.wangyj.api.controller;

import com.wangyj.api.model.po.ShopRole;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.service.RoleService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/role")
public class RoleController {

    @Autowired
    private RoleService  roleService;


    @PostMapping("queryData")
    public ResultData  queryData(){

        List<ShopRole> shopRoles = roleService.queryData();

        return ResultData.success(shopRoles);
    }

    @PostMapping("addRole")
    public  ResultData  addRole(ShopRole  role){

        roleService.addRole(role);

        return  ResultData.success(null);
    }

    @PostMapping("updateRole")
    public  ResultData  updateRole(ShopRole role){

        roleService.updateRole(role);

        return ResultData.success(null);
    }

    @DeleteMapping("deleteRole")
    public  ResultData  delteRole(Integer id){

        roleService.deleteRole(id);

        return   ResultData.success(null);
    }

}
