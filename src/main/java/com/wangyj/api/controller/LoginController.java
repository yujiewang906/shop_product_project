package com.wangyj.api.controller;

import com.wangyj.api.model.po.ShopUser;
import com.wangyj.api.model.vo.ResultData;
import com.wangyj.api.service.ShopUserService;
import com.wangyj.api.utils.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("api/login/")
@RestController
public class LoginController {

    @Autowired
    private ShopUserService  shopUserService;

    @RequestMapping("login")
    public Map  login(String  name,String password){

        Map  rs = new HashMap();
        //根据用户输入姓名查询用户信息
        ShopUser user = shopUserService.getDataByName(name);

        if (name.equals(user.getName())&&password.equals(user.getPassword())){
            Map map = new HashMap();
            map.put("name",name);
            map.put("password",password);
            //声明令牌
            String token = JWT.sign(map,600000*30);
            rs.put("code",200);
            rs.put("data",token);
            rs.put("message","success");
        }else{
            rs.put("code",500);
            rs.put("data","");
            rs.put("message","用户名或密码错误");
        }

        return rs;
    }




}
