package com.wangyj.api.dao;

import com.wangyj.api.model.po.ShopType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface ShopTypeDao {



    @Select("select * from  shop_type")
    public List<ShopType> getData();


    @Select("select * from shop_type where isDel=0 and pid = #{pid}")
    public List<ShopType> getDataByPid(Integer pid);


    //新增
    public void add(ShopType shopType);


    void update(ShopType shopType);

}
