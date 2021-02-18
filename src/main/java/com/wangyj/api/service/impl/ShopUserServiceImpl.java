package com.wangyj.api.service.impl;

import com.wangyj.api.dao.ShopUserDao;
import com.wangyj.api.service.ShopUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopUserServiceImpl implements ShopUserService {


    @Resource
    private ShopUserDao  shopUserDao;





}
