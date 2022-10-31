package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 面向comment表的数据访问层
 */
public interface CommentDao {
    @Insert("insert into comment values(null, #{userId}, #{noteId}, #{content}, #{dateTime})")
    int save(Comment comment);

    @Delete("delete from comment where id=#{id}")
    int delete(Integer id);

    @Select("select * from comment where id=#{id}")
    Comment findById(Integer id);

    // 根据note的id查找此note的所有comment
    @Select("select * from comment where note_id=#{id}")
    List<Comment> findByNoteId(Integer id);

    // 根据user的id查找此user的所有comment
    @Select("select * from comment where user_id=#{id}")
    List<Comment> findByUserId(Integer id);
}
