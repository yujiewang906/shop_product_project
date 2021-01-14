package com.wangyj.api.service;

import com.wangyj.api.model.po.ShopBrand;
import com.wangyj.api.model.vo.ShopParamsVo;

import java.util.Map;

public interface ShopBrandService {


    Map queryData(ShopParamsVo vo);


    void addBrand(ShopBrand shopBrand);


    void updateBrand(ShopBrand shopBrand);

    void deleteBrand(Integer id);
}
