package com.wangyj.api.dao;

import com.wangyj.api.model.po.ShopUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ShopUserDao {

    @Insert("insert into shop_user (name,realName,password,sex,phone,email,idCard,birthday,imgUrl,eduId,deptId,createDate,updateDate)" +
            "value(#{name},#{realName},#{password},#{sex},#{phone},#{email},#{idCard},#{birthday},#{eduId},#{deptId},#{createDate},#{updateDate})")
    void addUser(ShopUser user);

    @Select("select * from shop_user where name= #{name}")
    ShopUser getDataByName(String name);
}
