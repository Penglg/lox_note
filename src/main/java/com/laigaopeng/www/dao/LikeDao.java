package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LikeDao {
    @Insert("insert into like values(null, #{userId}, #{noteId})")
    int insert(Like like);

    @Delete("delete from like where id=#{id}")
    int delete(Integer id);

    @Select("select * from like where id=#{id}")
    Like findById(Integer id);

    @Select("select * from like where user_id=#{userId}")
    List<Like> findByUserId(Integer userId);
}
