package com.laigaopeng.www.dao;

import com.laigaopeng.www.pojo.Section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SectionDao {
    @Insert("insert into section values(null, #{name}, #{desc})")
    int save(Section section);

    @Delete("delete from section where id=#{id}")
    int delete(Integer id);

    @Update("update section set name=#{name}, desc=#{desc}")
    int update(Section section);

    @Select("select * from section where id=#{id}")
    Section findById(Integer id);

    @Select("select * from section")
    List<Section> findAll();
}
