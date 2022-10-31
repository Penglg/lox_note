package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectionDao {
    @Insert("insert into collection values(null, #{userId}, #{noteId})")
    int insert(Collection collection);

    @Delete("delete from collection where id=#{id}")
    int delete(Integer id);

    @Select("select * from collection where id=#{id}")
    Collection findById(Integer id);

    @Select("select * from collection where user_id=#{userId}")
    List<Collection> findByUserId(Integer userId);
}
