package com.wangyj.api.dao;

import com.wangyj.api.model.po.ShopAttribute;
import com.wangyj.api.model.vo.ShopParamsVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopAttributeDao {


    List<ShopAttribute> getData(ShopParamsVo vo);


    Integer  getCount(ShopParamsVo vo);


    void addAttribute(ShopAttribute shopAttribute);


    void updateAttribute(ShopAttribute shopAttribute);

    @Delete("update shop_attribute set isDel=1 where id = #{id}")
    void deleteAttribute(Integer id);

    @Select("select * from shop_attribute where typeId = #{pid}")
    List<ShopAttribute> getDataByPid(Integer pid);
}
