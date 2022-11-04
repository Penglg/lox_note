package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.NoteProvider;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.Section;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向note的数据访问层
 *
 */
public interface NoteDao {

    @Insert("insert into note (title, user_id, content, section_id, datetime) values " +
            "(#{title}, #{userId}, #{content}, #{sectionId}, #{dateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Note note);

    @Delete("delete from note where id = #{id}")
    int delete(Integer id);

    @UpdateProvider(type = NoteProvider.class, method = "updateNote")
    int update(@Param("note") Note note);

    @Select("select * from note where id = #{id}")
    @Results(id = "noteMap",value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "section_id", property = "sectionId"),
            @Result(column = "datetime", property = "dateTime"),
            @Result(
                    property = "tags",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.laigaopeng.www.dao.TagDao.findByNoteId")
            ),
            @Result(
                    property = "section",
                    column = "section_id",
                    javaType = Section.class,
                    one = @One(select = "com.laigaopeng.www.dao.SectionDao.findById")
            )
    })
    Note getById(Integer id);

    @Select("select * from note")
    @ResultMap("noteMap")
    List<Note> listAll();

    @SelectProvider(type = NoteProvider.class, method = "listNote")
    @ResultMap("noteMap")
    List<Note> listByConditions(@Param("sectionId") Integer sectionId, @Param("legal")Integer legal);

    /**
     * 根据user主键id获取该user所有笔记
     *
     * @param userId user主键id
     * @return 集合结果
     */
    @Select("select * from note where user_id=#{userId}")
    @ResultMap("noteMap")
    List<Note> listByUserId(Integer userId);

    /**
     * 根据user主键id获取user点赞的笔记
     *
     * @param userId user主键id
     * @return 集合结果
     */
    @Select("select * from note n, like l where n.id = l.note_id and l.user_id = #{userId}")
    @ResultMap("noteMap")
    List<Note> listLikes(Integer userId);

    /**
     * 根据user主键id获取user收藏的笔记
     *
     * @param userId user主键id
     * @return 集合结果
     */
    @Select("select * from note n, connect c where n.id = c.note_id and c.user_id = #{userId}")
    @ResultMap("noteMap")
    List<Note> listCollections(Integer userId);
}
