package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.ApprovalProvider;
import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 免表approval表的数据访问层
 *
 */
public interface ApprovalDao {
    @Insert("insert into approval (note_id, user_id, content) values " +
            "(#{noteId}, #{userId}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Approval approval);

    /**
     * 对approval进行更新
     * s
     * @param approval approval对象
     * @return 影响行数
     */
    @UpdateProvider(type = ApprovalProvider.class, method = "updateApproval")
    int update(@Param("approval") Approval approval);

    @Delete("delete from approval where id=#{id}")
    int delete(Integer id);

    @Select("select * from approval where id=#{id}")
    @Results(id = "approvalMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "content", property = "content"),
            @Result(column = "result", property = "result")
    })
    Approval getById(Integer id);

    @Select("select * from approval")
    @Results(id = "approvalUserNoteMap", value = {
            @Result(column = "id", property = "id", id = true),
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
    List<Approval> listAll();

    /**
     * 根据user主键id获取user所有申请
     *
     * @param userId userId
     * @return 查询到的申请集合
     */
    @Select("select * from approval where user_id=#{userId}")
    @ResultMap("approvalMap")
    List<Approval> listByUserId(Integer userId);

    /**
     * 管理员获取所有未处理的笔记审批申请
     *
     * @return 查询到的申请集合
     */
    @Select("select * from approval a, note n where a.result=-1 and n.section_id = #{sectionId} limit #{begin}, " +
            "#{pageSize}")
    @ResultMap("approvalUserNoteMap")
    List<Approval> listUnprocessed(@Param("sectionId") Integer sectionId, @Param("sectionId") Integer begin,
                                   @Param("pageSize") Integer pageSize);

    /**
     * 管理员获取所有未处理的笔记审批申请
     *
     * @return 查询到的申请集合
     */
    @Select("select count(*) from approval a, note n where a.result=-1 and n.section_id = #{sectionId}")
    int totalCountUnprocessed(@Param("sectionId") Integer sectionId);
}
