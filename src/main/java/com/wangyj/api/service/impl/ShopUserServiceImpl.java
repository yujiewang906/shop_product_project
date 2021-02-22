package com.wangyj.api.service.impl;

import com.wangyj.api.dao.ShopUserDao;
import com.wangyj.api.model.po.ShopUser;
import com.wangyj.api.service.ShopUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopUserServiceImpl implements ShopUserService {


    @Resource
    private ShopUserDao  shopUserDao;


    @Override
    public void addUser(ShopUser user) {
        shopUserDao.addUser(user);
    }

    @Override
    public ShopUser getDataByName(String name) {

        ShopUser user = shopUserDao.getDataByName(name);

        return user;
    }
}
