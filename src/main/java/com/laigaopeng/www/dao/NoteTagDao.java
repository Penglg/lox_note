package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.NoteTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 面向note表的数据访问层
 */
public interface NoteTagDao {
    @Insert("insert into note_tag values(null, noteId, tagId)")
    int insert(NoteTag noteTag);

    @Delete("delete from note_tag where id=#{id}")
    int delete(Integer id);

    @Update("update note_tag set tag_id=#{tagId} where id=#{id}")
    int update(NoteTag noteTag);

    @Select("select * from note_tag where id=#{id}")
    NoteTag findById(Integer id);

    /**
     * 根据笔记追主键id获取该笔记所有标签
     * @param noteId noteId
     * @return 集合结果
     */
    @Select("select * from note_tag where note_id=#{noteId}")
    List<NoteTag> findByNoteId(Integer noteId);

    /**
     * 根绝标签主键id获取拥有该标签的笔记
     * @param tagId tag主键id
     * @return 集合结果
     */
    @Select("select * from note_tag where tag_id=#{tagId}")
    List<NoteTag> findByTagId(Integer tagId);
}
