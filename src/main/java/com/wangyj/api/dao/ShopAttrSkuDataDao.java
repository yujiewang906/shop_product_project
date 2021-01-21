package com.wangyj.api.dao;

import com.wangyj.api.model.po.ProductAttrData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopAttrSkuDataDao {


    @Insert("insert into shop_attrData (proId,attrData,storcks,price) " +
            "value(#{proId},#{attrData},#{storcks},#{price})")
    public void add(ProductAttrData pad);
    @Insert("<script>insert into shop_attrData (proId,attrData,storcks,price) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.proId},#{a.attrData},#{a.storcks},#{a.price} )  </foreach> </script>")
    public void adds(List<ProductAttrData> list);

}
