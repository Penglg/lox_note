package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.TagProvider;
import com.laigaopeng.www.pojo.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向tag_dao表的数据访问层
 *
 */
public interface TagDao {
    @Insert("insert into tag (name, desc) values (#{name}, #{desc})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Tag tag);

    @Delete("delete from tag where id=#{id}")
    int delete(Integer id);

    @UpdateProvider(type = TagProvider.class, method = "updateTag")
    int update(Tag tag);

    @Select("select * from tag where id=#{id}")
    @Result(column = "id", property = "id", id = true)
    Tag getById(Integer id);

    @Select("select * from tag where name=#{name}")
    @Result(column = "id", property = "id", id = true)
    Tag getByName(String name);

    @Select("select * from tag")
    @Result(column = "id", property = "id", id = true)
    List<Tag> listAll();

    /**
     * 根据笔记主键id查找对应标签集合
     *
     * @param noteId 笔记主键id
     * @return 集合对象
     */
    @Select("select * from tag t, note_tag nt where nt.note_id = #{noteId} and t.id = nt.tag_id")
    @Result(column = "id", property = "id", id = true)
    List<Tag> listByNoteId(Integer noteId);
}
