package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.UserProvider;
import com.laigaopeng.www.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向user表的数据访问层
 */
public interface UserDao {
    @Insert("insert into user (name, account, password, sex, create_date) values " +
            "(#{name}, #{account}, #{password}, #{sex}, #{createDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(User user);

    @Delete("delete from user where id = #{id}")
    int delete(Integer id);

    @UpdateProvider(type = UserProvider.class, method = "updateUser")
    int update(@Param("user") User user);

    /**
     * 根据id查找User
     * @param id 主键
     * @return User对象
     */
    @Select("select * from user where id = #{id}")
    @Results(id = "userMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "create_date", property = "createDate")
    })
    User getById(Integer id);

    @Select("select * from user")
    @ResultMap("userMap")
    List<User> findAll();

    /**
     * 查找User及其所有角色
     * @param userId user主键id
     * @return user对象
     */
    @Select("select * from user where id = #{id}")
    @Results(id = "userAndRoleMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "create_date", property = "createDate"),
            @Result(
                    property = "roles",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.laigaopeng.www.dao.RoleDao.findByUserId")
            )
    })
    User getUserAndRolesById(Integer userId);

    @Select("select * from user where account = #{account}")
    @ResultMap("userMap")
    User getByAccount(String account);

    @Select("select * from user where name = #{name}")
    @ResultMap("userMap")
    User getByName(String name);

    @Select("select * from user where account = #{account} and password = #{password}")
    @ResultMap("userAndRoleMap")
    User getByAccAndPwd(String account, String password);
}
