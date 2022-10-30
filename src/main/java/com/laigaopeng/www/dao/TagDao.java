package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TagDao {
    @Insert("insert into tag values(null, #{name}, #{desc})")
    int save(Tag tag);

    @Delete("delete from tag where id=#{id}")
    int delete(Integer id);

    @Update("update tag set name=#{name}, desc=#{desc}")
    int update(Tag tag);

    @Select("select * from tag where id=#{id}")
    Tag findById(Integer id);

    @Select("select * from tag")
    List<Tag> findAll();
}
