package com.wangyj.api.dao;

import com.wangyj.api.model.po.ShopAttributeValue;
import com.wangyj.api.model.vo.ShopParamsVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopAttributeValueDao {

    @Select("SELECT  s.* from shop_attribute_value  " +
            "s LEFT JOIN shop_attribute a ON s.attrId = a.id  " +
            "where  s.attrId =#{id} and isDel = 0  limit ${(page-1)*currPage},#{currPage}")
    List<ShopAttributeValue> getData(ShopParamsVo vo);

    @Select("SELECT  count(*) from shop_attribute_value where attrId =#{id} and isDel=0")
    Integer  getCount(ShopParamsVo vo);


    @Insert("insert into shop_attribute_value (name,nameCH,attrId,isDel) value(#{name},#{nameCH},#{attrId},0)")
    void addAttributeValue(ShopAttributeValue value);


    @Update("update  shop_attribute_value  set name = #{name},nameCH=#{nameCH},attrId=#{attrId} where id = #{id}")
    void updateAttributeValue(ShopAttributeValue value);


    @Delete("update shop_attribute_value set isDel = 1  where id = #{id}")
    void deleteAttributeValue(Integer id);
}
