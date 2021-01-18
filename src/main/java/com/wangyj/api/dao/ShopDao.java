package com.wangyj.api.dao;

import com.wangyj.api.model.po.Shop;
import com.wangyj.api.model.vo.ShopParamsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopDao {

    @Select("select * from t_shop")
    public   List<Shop> getData(ShopParamsVo vo);

    @Select("select count(*) from t_shop")
    public   Integer   getShopCount(ShopParamsVo vo);
}
