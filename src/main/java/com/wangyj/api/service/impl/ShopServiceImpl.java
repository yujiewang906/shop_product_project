package com.wangyj.api.service.impl;

import com.wangyj.api.dao.ShopDao;
import com.wangyj.api.model.po.Shop;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopDao shopDao;

    @Override
    public Map getData(ShopParamsVo vo) {

        Map map = new HashMap();

        List<Shop> data = shopDao.getData(vo);
        map.put("data",data);

        Integer shopCount = shopDao.getShopCount(vo);
        map.put("count",shopCount);


        return map;
    }

    @Override
    public void addShop(Shop shop) {
        shopDao.addShop(shop);
    }
}
