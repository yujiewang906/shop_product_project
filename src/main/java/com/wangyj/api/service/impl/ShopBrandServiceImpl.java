package com.wangyj.api.service.impl;

import com.wangyj.api.dao.ShopBrandDao;
import com.wangyj.api.model.po.ShopBrand;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopBrandServiceImpl implements ShopBrandService {

    @Resource
    private ShopBrandDao  shopBrandDao;

    @Override
    public Map queryData(ShopParamsVo vo) {

         Map map = new HashMap<>();

        Integer count = shopBrandDao.queryCountBrand(vo);
        map.put("count",count);

        List<ShopBrand> shopBrands = shopBrandDao.queryData(vo);
        map.put("data",shopBrands);

        return map;
    }

    @Override
    public void addBrand(ShopBrand shopBrand) {
        shopBrandDao.addBrand(shopBrand);
    }

    @Override
    public void updateBrand(ShopBrand shopBrand) {

        shopBrandDao.updateBrand(shopBrand);
    }

    @Override
    public void deleteBrand(Integer id) {

        shopBrandDao.deleteBrand(id);

    }
}
