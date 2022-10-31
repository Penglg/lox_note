package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 免表approval表的数据访问层
 */
public interface ApprovalDao {
    @Insert("insert into approval values(null, #{noteID}, #{userId}, #{content}, #{result})")
    int insert(Approval approval);

    /**
     * 对approval的result结果进行更新
     * @param approval approval对象
     * @return 影响行数
     */
    @Update("update approval set result=#{result} where id=#{id}")
    int update(Approval approval);

    @Delete("delete from approval where id=#{id}")
    int delete(Integer id);

    @Select("select * from approval where id=#{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "content", property = "content"),
            @Result(column = "result", property = "result")
    })
    Approval findById(Integer id);

    @Select("select * from approval")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "content", property = "content"),
            @Result(column = "result", property = "result"),
            @Result(
                    property = "user", // 封装的User属性
                    column = "user_id",
                    javaType = User.class,
                    // select属性
                    one = @One(select = "com.laigaopeng.www.dao.UserDao.findById")
            ),
            @Result(
                    property = "note", // 封装的Note属性
                    column = "note_id",
                    javaType = Note.class,
                    one = @One(select = "com.laigaopeng.www.dao.NoteDao.findById")

            )
    })
    List<Approval> findAll();

    /**
     * 根据user主键id获取user所有申请
     * @param userId userId
     * @return 查询到的申请集合
     */
    @Select("select * from approval where user_id=#{userId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "content", property = "content"),
            @Result(column = "result", property = "result")
    })
    List<Approval> findByUserId(Integer userId);

    /**
     * 管理员获取所有未处理的笔记审批申请
     * @return 查询到的申请集合
     */
    @Select("select * from approval where result=-1")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "content", property = "content"),
            @Result(column = "result", property = "result"),
            @Result(
                    property = "user", // 封装的User属性
                    column = "user_id",
                    javaType = User.class,
                    // select属性
                    one = @One(select = "com.laigaopeng.www.dao.UserDao.findById")
            ),
            @Result(
                    property = "note", // 封装的Note属性
                    column = "note_id",
                    javaType = Note.class,
                    one = @One(select = "com.laigaopeng.www.dao.NoteDao.findById")

            )
    })
    List<Approval> findUnprocessed();
}
