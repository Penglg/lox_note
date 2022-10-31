package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向role表的数据访问层
 */
public interface RoleDao {
    @Insert("insert into role values(null, #{name}, #{permissionLevel}, #{desc})")
    int save(Role role);

    @Delete("delete from role where id=#{id}")
    int delete(Integer id);

    @Update("update role set name=#{name}, permission_level=#{permissionLevel}, desc=#{desc}")
    int update(Role role);

    @Select("select * from role where id=#{id}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "permission_level", property = "permissionLevel")
    })
    Role findById(Integer id);

    @Select("select * from role")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "permission_level", property = "permissionLevel")
    })
    List<Role> findAll();
}
