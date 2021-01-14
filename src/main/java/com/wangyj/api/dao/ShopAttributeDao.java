package com.wangyj.api.dao;

import com.wangyj.api.model.po.ShopAttribute;
import com.wangyj.api.model.vo.ShopParamsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopAttributeDao {


    List<ShopAttribute> getData(ShopParamsVo vo);

    Integer  getCount(ShopParamsVo vo);


    void addAttribute(ShopAttribute shopAttribute);
}
