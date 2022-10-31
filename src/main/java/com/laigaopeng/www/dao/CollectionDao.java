package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Collection;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向collection表的数据访问层
 */
public interface CollectionDao {
    @Insert("insert into collection values(null, #{userId}, #{noteId})")
    int insert(Collection collection);

    @Delete("delete from collection where id=#{id}")
    int delete(Integer id);

    @Select("select * from collection where id=#{id}")
    @Results(id = "collectionMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "noteId"),
            @Result(column = "note_id", property = "noteId")
    })
    Collection findById(Integer id);

    @Select("select * from collection where user_id=#{userId}")
    @ResultMap("collectionMap")
    List<Collection> findByUserId(Integer userId);
}
