package com.wangyj.api.service.impl;

import com.wangyj.api.dao.ShopAttributeDao;
import com.wangyj.api.model.po.ShopAttribute;
import com.wangyj.api.model.vo.ShopParamsVo;
import com.wangyj.api.service.ShopAttributeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopAttributeServiceImpl implements ShopAttributeService {

    @Resource
    private ShopAttributeDao shopAttributeDao;

    @Override
    public Map getData(ShopParamsVo vo) {

        Map map = new HashMap<>();

        Integer count = shopAttributeDao.getCount(vo);
        map.put("count",count);

        List<ShopAttribute> attribute = shopAttributeDao.getData(vo);
        map.put("attribute",attribute);

        return map;
    }

    @Override
    public void addAttribute(ShopAttribute shopAttribute) {

        shopAttributeDao.addAttribute(shopAttribute);
    }

    @Override
    public void updateAttribute(ShopAttribute shopAttribute) {

        shopAttributeDao.updateAttribute(shopAttribute);
    }

    @Override
    public void deleteAttribute(Integer id) {
        shopAttributeDao.deleteAttribute(id);
    }

    @Override
    public Map getDataByPid(Integer pid) {
        Map map = new HashMap();
        List<ShopAttribute> dataByPid = shopAttributeDao.getDataByPid(pid);
        map.put("data",dataByPid);
        return map;

    }
}
