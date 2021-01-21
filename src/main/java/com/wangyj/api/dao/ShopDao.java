package com.wangyj.api.dao;

import com.wangyj.api.model.po.Shop;
import com.wangyj.api.model.vo.ShopParamsVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopDao {

    @Select("select * from t_shop where 1=1  limit ${(page-1)*currPage},#{currPage}")
    public   List<Shop> getData(ShopParamsVo vo);

    @Select("select count(*) from t_shop ")
    public   Integer   getShopCount(ShopParamsVo vo);


    @Insert("insert into t_shop (name,title,brandId,productdecs,imgPath,price,stocks,sortNum,createDate,updateDate,author,isDel) value " +
            "(#{name},#{title},#{brandId},#{productdecs},#{imgPath},#{price},#{stocks},#{sortNum},NOW(),NOW(),#{author},#{isDel})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public   void addShop(Shop shop);

    @Update("update t_shop set name = #{name},title=#{title},brandId=#{brandId},imgPath=#{imgPath},productdecs=#{productdecs},price=#{price},stocks=#{stocks},sortNum=#{sortNum},updateDate=NOW(),author = #{author},isDel = #{isDel} where id=#{id}")
    public  void updateShop(Shop shop);

}
