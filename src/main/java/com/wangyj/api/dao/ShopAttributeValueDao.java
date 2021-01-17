package com.wangyj.api.dao;

import com.wangyj.api.model.po.ShopAttributeValue;
import com.wangyj.api.model.vo.ShopParamsVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShopAttributeValueDao {

    @Select("select * from shop_attribute_value where 1=1 limit ${(page-1)*currPage},#{currPage}")
    List<ShopAttributeValue> getData(ShopParamsVo vo);

    @Select("select count(*) shop_attribute_value")
    Integer  getCount(ShopParamsVo vo);


    @Insert("insert into shop_attribute_value (name,nameCH,attrId) value(#{name},#{nameCH},#{attrId})")
    void addAttributeValue(ShopAttributeValue value);
}
