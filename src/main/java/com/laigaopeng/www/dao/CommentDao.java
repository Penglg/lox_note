package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.CommentProvider;
import com.laigaopeng.www.pojo.Comment;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向comment表的数据访问层
 *
 */
public interface CommentDao {
    @Insert("insert into comment (user_id, note_id, content, datetime) values " +
            "(null, #{userId}, #{noteId}, #{content}, #{dateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Comment comment);

    @Delete("delete from comment where id=#{id}")
    int delete(Integer id);

    @DeleteProvider(type = CommentProvider.class, method = "deleteComment")
    int deleteByConditions(@Param("comment") Comment comment);

    @Select("select * from comment where id=#{id}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "content", property = "content"),
            @Result(column = "datetime", property = "dateTime")
    })
    Comment getById(Integer id);

    /**
     * 根据note的id查找此note的所有comment
     *
     * @param id id
     * @return 集合结果
     */
    @Select("select * from comment where note_id=#{id}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "content", property = "content"),
            @Result(column = "datetime", property = "dateTime"),
            @Result(
                    property = "user",
                    column = "user_id",
                    javaType = User.class,
                    one = @One(select = "com.laigaopeng.www.dao.UserDao.findById")
            )
    })
    List<Comment> listByNoteId(Integer id);

    /**
     * 根据user的id查找此user的所有comment
     *
     * @param userId userId
     * @return 集合结果
     */
    @Select("select * from comment where user_id=#{userId}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "content", property = "content"),
            @Result(column = "datetime", property = "dateTime"),
            @Result(
                    property = "note",
                    column = "note_id",
                    javaType = Note.class,
                    one = @One(select = "com.laigaopeng.www.dao.NoteDao.findById")
            )
    })
    List<Comment>listByUserId(Integer userId);
}
