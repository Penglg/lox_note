package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 面向user表的数据访问层
 */
public interface UserDao {
    @Insert("insert into user values (null, #{name}, #{account}, #{password}, #{sex}, null, null, #{createDate}})")
    int save(User user);

    @Delete("delete from user where id = #{id}")
    int delete(Integer id);

    @Update("update user set name=#{name}, password=#{password}, sex=#{sex} where id = #{id}")
    int update(User user);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Select("select * from user")
    List<User> findAll();
}
