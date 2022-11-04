package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.SectionProvider;
import com.laigaopeng.www.pojo.Section;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 卖你想section表的数据访问层
 *
 */
public interface SectionDao {
    @Insert("insert into section (name, desc) values(#{name}, #{desc})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Section section);

    @Delete("delete from section where id=#{id}")
    int delete(Integer id);

    @UpdateProvider(type = SectionProvider.class, method = "updateSection")
    int update(Section section);

    @Select("select * from section where id=#{id}")
    @Result(column = "id", property = "id", id = true)
    Section getById(Integer id);

    @Select("select * from section where name=#{name}")
    @Result(column = "id", property = "id", id = true)
    Section getByName(String name);

    @Select("select * from section")
    @Result(column = "id", property = "id", id = true)
    List<Section> listAll();
}
