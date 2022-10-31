package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.NoteTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NoteTagDao {
    @Insert("insert into note_tag values(null, noteId, tagId)")
    int insert(NoteTag noteTag);

    @Delete("delete from note_tag where id=#{id}")
    int delete(Integer id);

    @Update("update note_tag set tag_id=#{tagId} where id=#{id}")
    int update(NoteTag noteTag);

    @Select("select * from note_tag where id=#{id}")
    NoteTag findById(Integer id);

    @Select("select * from note_tag where note_id=#{noteId}")
    List<NoteTag> findByNoteId(Integer noteId);

    @Select("select * from note_tag where tag_id=#{tagId}")
    List<NoteTag> findByTagId(Integer tagId);
}
