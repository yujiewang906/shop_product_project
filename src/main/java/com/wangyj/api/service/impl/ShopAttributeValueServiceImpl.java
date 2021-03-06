package com.wangyj.api.service.impl;

import com.wangyj.api.dao.ShopAttributeValueDao;
import com.wangyj.api.model.po.ShopAttributeValue;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopAttributeValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopAttributeValueServiceImpl implements ShopAttributeValueService {


    @Resource
    private ShopAttributeValueDao shopAttributeValueDao;


    @Override
    public Map getData(ShopParamsVo vo) {

        Map  map = new HashMap();
        List<ShopAttributeValue> data = shopAttributeValueDao.getData(vo);
        map.put("data",data);
        Integer count = shopAttributeValueDao.getCount(vo);
        map.put("count",count);

        return  map;
    }

    @Override
    public void addAttributeValue(ShopAttributeValue value) {
        shopAttributeValueDao.addAttributeValue(value);
    }

    @Override
    public void updateAttributeValue(ShopAttributeValue value) {
        shopAttributeValueDao.updateAttributeValue(value);
    }

    @Override
    public void deleteAttributeValue(Integer id) {
        shopAttributeValueDao.deleteAttributeValue(id);
    }

    @Override
    public Map queryDataByAid(Integer aid) {
        Map  map = new HashMap();
        List<ShopAttributeValue> data = shopAttributeValueDao.queryDataByAid(aid);
        map.put("data",data);
        return map;
    }
}
