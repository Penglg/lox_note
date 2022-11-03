package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向user_role表的数据访问层实现
 */
public interface UserRoleDao {
    @Insert("insert into user_role values(null, userId, roleId)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserRole userRole);

    @Delete("delete from user_role where id=#{id}")
    int delete(Integer id);

    @Select("select * from user_role where id=#{id}")
    UserRole findById(Integer id);

    /**
     * 根据用户主键id获取user_role数据
     * @param userId 用户主键id
     * @return 查询结果
     */
    @Select("select * from user_role where user_id=#{userId}")
    @Results(id = "userRoleMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "role_id", property = "roleId")
    })
    List<UserRole> findByUserId(Integer userId);

    /**
     * 根据角色主键id获取user_role数据
     * @param roleId roleId
     * @return 集合结果
     */
    @Select("select * from user_role where role_id=#{roleId}")
    @ResultMap("userRoleMap")
    List<UserRole> findByRoleId(Integer roleId);
}
