package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.RoleProvider;
import com.laigaopeng.www.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向role表的数据访问层
 *
 */
public interface RoleDao {
    @Insert("insert into role (name, permission_level, `desc`) values (#{name}, #{permissionLevel}, #{desc})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Role role);

    @Delete("delete from role where id=#{id}")
    int delete(Integer id);

    @UpdateProvider(type = RoleProvider.class, method = "updateRole")
    int update(Role role);

    @Select("select * from role where id=#{id}")
    @Results(id = "roleMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "permission_level", property = "permissionLevel")
    })
    Role getById(Integer id);

    @Select("select * from role")
    @ResultMap("roleMap")
    List<Role> listAll();

    /**
     * 根据user的id多表查询user对应的角色
     *
     * @param userId user主键id
     * @return 查询到的角色
     */
    @Select("select * from role r, user_role ur where r.id = ur.role_id and ur.user_id = #{userId}")
    @ResultMap("roleMap")
    List<Role> listByUserId(Integer userId);
}
