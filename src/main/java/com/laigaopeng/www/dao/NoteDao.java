package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Note;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Update("update note set title=#{title}, content=#{content}, section_id=#{sectionId}")
    int update(Note note);

    @Select("select * from note where id = #{id}")
    Note findById(Integer id);

    @Select("select * from note")
    List<Note> findAll();
}
