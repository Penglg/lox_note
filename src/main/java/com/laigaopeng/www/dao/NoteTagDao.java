package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.NoteTagProvider;
import com.laigaopeng.www.pojo.NoteTag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向note表的数据访问层
 *
 */
public interface NoteTagDao {
    @Insert("insert into note_tag values(null, noteId, tagId)")
    int insert(NoteTag noteTag);

    @Delete("delete from note_tag where id=#{id}")
    int delete(Integer id);

    @DeleteProvider(type = NoteTagProvider.class, method = "deleteNoteTag")
    int deleteByConditions(@Param("noteTag") NoteTag noteTag);

    @UpdateProvider(type = NoteTagProvider.class, method = "updateNoteTag")
    int update(@Param("noteTag") NoteTag noteTag);

    @Select("select * from note_tag where id=#{id}")
    @Results(id = "noteTagMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "note_id", property = "noteId"),
            @Result(column = "tag_id", property = "tagId")
    })
    NoteTag listById(Integer id);

    /**
     * 根据笔记追主键id获取该笔记所有标签
     *
     * @param noteId noteId
     * @return 集合结果
     */
    @Select("select * from note_tag where note_id=#{noteId}")
    @ResultMap("noteTagMap")
    List<NoteTag> listByNoteId(Integer noteId);

    /**
     * 根绝标签主键id获取拥有该标签的笔记
     *
     * @param tagId tag主键id
     * @return 集合结果
     */
    @Select("select * from note_tag where tag_id=#{tagId}")
    @ResultMap("noteTagMap")
    List<NoteTag> listByTagId(Integer tagId);
}
