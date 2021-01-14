package com.wangyj.api.service;

import com.wangyj.api.model.po.ShopAttribute;
import com.wangyj.api.model.vo.ShopParamsVo;

import java.util.Map;

public interface ShopAttributeService {



         Map getData(ShopParamsVo vo);

    void addAttribute(ShopAttribute shopAttribute);


}
