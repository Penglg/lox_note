package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.NoteProvider;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.Section;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向note的数据访问层
 */
public interface NoteDao {

    @Insert("insert into note values(null, #{tile}, #{userId}, #{content}, null, #{sectionId}, null, null, " +
            "#{dateTime})")
    int save(Note note);

    @Delete("delete from note where id = #{id}")
    int delete(Integer id);

    @UpdateProvider(type = NoteProvider.class, method = "updateNote")
    int update(@Param("note") Note note);

    @Select("select * from note where id = #{id}")
    @Results(id = "noteMap",value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "title", property = "tile"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "content", property = "content"),
            @Result(column = "photo", property = "photo"),
            @Result(column = "section_id", property = "sectionId"),
            @Result(column = "likes", property = "likes"),
            @Result(column = "collect", property = "collect"),
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
    Note findById(Integer id);

    @Select("select * from note")
    @ResultMap("noteMap")
    List<Note> findAll();

    /**
     * 根据user主键id获取该user所有笔记
     * @param userId user主键id
     * @return 集合结果
     */
    @Select("select * from note where user_id=#{userId}")
    @ResultMap("noteMap")
    List<Note> findByUserId(Integer userId);

    /**
     * 根据user主键id获取user点赞的笔记
     * @param userId user主键id
     * @return 集合结果
     */
    @Select("select * from note n, like l where n.id = l.note_id and l.user_id = #{userId}")
    @ResultMap("noteMap")
    List<Note> findLikes(Integer userId);

    /**
     * 根据user主键id获取user收藏的笔记
     * @param userId user主键id
     * @return 集合结果
     */
    @Select("select * from note n, connect c where n.id = c.note_id and c.user_id = #{userId}")
    @ResultMap("noteMap")
    List<Note> findCollections(Integer userId);
}
