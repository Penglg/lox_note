package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserRoleDao {
    @Insert("insert into user_role values(null, userId, roleId)")
    int insert(UserRole userRole);

    @Delete("delete from user_role where id=#{id}")
    int delete(Integer id);

    @Update("update user_role set role_id=#{roleId} where id=#{id}")
    int update(UserRole userRole);

    @Select("select * from user_role where id=#{id}")
    UserRole findById(Integer id);

    @Select("select * from user_role where user_id=#{userId}")
    List<UserRole> findByUserId(Integer noteId);

    @Select("select * from user_role where role_id=#{roleId}")
    List<UserRole> findByRoleId(Integer tagId);
}
