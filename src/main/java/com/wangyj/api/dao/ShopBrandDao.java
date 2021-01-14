package com.wangyj.api.dao;

import com.wangyj.api.model.po.ShopBrand;
import com.wangyj.api.model.vo.ShopParamsVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopBrandDao {



   public  List<ShopBrand> queryData(ShopParamsVo vo);

   public  Integer  queryCountBrand(ShopParamsVo vo);

    public void addBrand(ShopBrand shopBrand);

    public void updateBrand(ShopBrand shopBrand);

     @Delete("update shop_brand set isDel=1 where id = #{id}")
     public void deleteBrand(Integer id);
}
