package com.wangyj.api.controller;

import com.wangyj.api.model.po.ShopUser;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.service.ShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class ShopUserController {

    @Autowired
    private ShopUserService shopUserService;


    @PostMapping("addUser")
    public ResultData  addUser(ShopUser user){

        if (user.getPassword()==""){
            return ResultData.error(500,"请输入密码");
        }
        if (user.getName()==""){
            return ResultData.error(500,"请输入用户名");
        }
        shopUserService.addUser(user);

        return  ResultData.success(null);
    }


}
