package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Like;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向like的数据访问层
 */
public interface LikeDao {
    @Insert("insert into like values(null, #{userId}, #{noteId})")
    int insert(Like like);

    @Delete("delete from like where id=#{id}")
    int delete(Integer id);

    @Select("select * from like where id=#{id}")
    @Results(id = "likeMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "note_id", property = "noteId")
    })
    Like findById(Integer id);

    @Select("select * from like where user_id=#{userId}")
    @ResultMap("likeMap")
    List<Like> findByUserId(Integer userId);
}
