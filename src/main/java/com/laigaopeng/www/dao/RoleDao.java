package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    Role findById(Integer id);

    @Select("select * from role")
    List<Role> findAll();
}
