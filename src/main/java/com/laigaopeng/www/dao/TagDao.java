package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向tag_dao表的数据访问层
 */
public interface TagDao {
    @Insert("insert into tag values(null, #{name}, #{desc})")
    int save(Tag tag);

    @Delete("delete from tag where id=#{id}")
    int delete(Integer id);

    @Update("update tag set name=#{name}, desc=#{desc}")
    int update(Tag tag);

    @Select("select * from tag where id=#{id}")
    @Result(column = "id", property = "id", id = true)
    Tag findById(Integer id);

    @Select("select * from tag")
    @Result(column = "id", property = "id", id = true)
    List<Tag> findAll();
}
