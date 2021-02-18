package com.wangyj.api.dao;

import com.wangyj.api.model.po.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PermissionDao {


    @Select("select * from  shop_permission where 1=1")
    List<Permission> selectPermission();

    @Insert("insert into  shop_permission (pid,name,url,type,isDel,createDate,author) value (#{pid},#{name},#{url},#{type},#{isDel},#{createDate},#{author})")
    void addPermission(Permission permission);


    @Update("update shop_permission set pid = #{pid},name = #{name},url = #{url},type = #{type},isDel = #{isDel},createDate = #{createDate}" +
            "author = #{author}")
    void updatePermission(Permission permission);

    @Delete("delete from shop_permission where id = #{id}")
    void deletePermission(Integer id);
}
