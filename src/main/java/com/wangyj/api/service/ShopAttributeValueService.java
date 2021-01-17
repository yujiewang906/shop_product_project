package com.wangyj.api.service;

import com.wangyj.api.model.po.ShopAttributeValue;
import com.wangyj.api.model.vo.ShopParamsVo;

import java.util.Map;

public interface ShopAttributeValueService {


    Map getData(ShopParamsVo vo);


    void addAttributeValue(ShopAttributeValue value);


    void updateAttributeValue(ShopAttributeValue value);


    void deleteAttributeValue(Integer id);
}
