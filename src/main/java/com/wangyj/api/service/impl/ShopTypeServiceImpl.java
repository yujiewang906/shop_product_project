package com.wangyj.api.service.impl;

import com.wangyj.api.dao.ShopTypeDao;
import com.wangyj.api.model.po.ShopType;
import com.wangyj.api.service.ShopTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopTypeServiceImpl  implements ShopTypeService {

    @Resource
    private ShopTypeDao  shopTypeDao;


    @Override
    public void add(ShopType shopType) {
        shopTypeDao.add(shopType);
    }

    @Override
    public Map getData() {

        Map map = new HashMap<>();

        List<ShopType> shopData = shopTypeDao.getData();
        map.put("data",shopData);

        return map;
    }

    @Override
    public Map getDataByPid(Integer pid) {

        Map map = new HashMap<>();
        List<ShopType> dataByPid = shopTypeDao.getDataByPid(pid);
        map.put("dataByPid",dataByPid);
        return  map;
    }

    @Override
    public void update(ShopType shopType) {
        shopTypeDao.update(shopType);
    }
}
