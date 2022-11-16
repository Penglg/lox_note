package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.ManagerSectionProvider;
import com.laigaopeng.www.pojo.ManagerSection;
import org.apache.ibatis.annotations.*;

/**
 * 数据访问层
 *
 */
public interface ManagerSectionDao {

    @Insert("insert into manager_section values (null, #{userId}, #{sectionId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int save(ManagerSection managerSection);

    @DeleteProvider(type = ManagerSectionProvider.class, method = "deleteManagerSection")
    public int delete(@Param("ms")ManagerSection managerSection);

    @Select("select * from manager_section where id = #{id}")
    @Results(id = "managerSectionMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "section_id", property = "sectionId")
    })
    public ManagerSection getById(Integer id);

    @Select("select * from manager_section where user_id = #{userId}")
    @ResultMap("managerSectionMap")
    public ManagerSection getByUserId(Integer userId);
}
