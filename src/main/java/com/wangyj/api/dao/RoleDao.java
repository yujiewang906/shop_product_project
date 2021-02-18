package com.wangyj.api.dao;

import com.wangyj.api.model.po.ShopRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {


    @Select("select * from shop_role where 1=1")
    List<ShopRole> queryData();

    @Insert("insert into shop_role  (name,isDel,createDate) value (#{name},#{isDel},#{createDate})")
    void addRole(ShopRole role);

    @Update("update shop_role  set name = #{name},isDel = #{isDel},createDate = #{createDate},author = #{author} where id = #{id}")
    void upDateRole(ShopRole role);

    @Delete("delete from shop_role where id = #{id}")
    void delteRole(Integer id);

}
