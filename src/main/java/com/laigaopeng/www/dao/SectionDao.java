package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Section;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 卖你想section表的数据访问层
 */
public interface SectionDao {
    @Insert("insert into section values(null, #{name}, #{desc})")
    int save(Section section);

    @Delete("delete from section where id=#{id}")
    int delete(Integer id);

    @Update("update section set name=#{name}, desc=#{desc}")
    int update(Section section);

    @Select("select * from section where id=#{id}")
    @Result(column = "id", property = "id", id = true)
    Section findById(Integer id);

    @Select("select * from section")
    @Result(column = "id", property = "id", id = true)
    List<Section> findAll();
}
