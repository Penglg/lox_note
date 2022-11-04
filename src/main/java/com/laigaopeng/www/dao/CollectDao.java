package com.laigaopeng.www.dao;

import com.laigaopeng.www.dao.provider.CollectProvider;
import com.laigaopeng.www.pojo.Collect;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 面向collection表的数据访问层
 */
public interface CollectDao {
    @Insert("insert into collect values(null, #{userId}, #{noteId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Collect collection);

    @Delete("delete from collect where id=#{id}")
    int delete(Integer id);

    @DeleteProvider(type = CollectProvider.class, method = "deleteCollect")
    int deleteByConditions(@Param("collect") Collect collect);

    @Select("select * from collect where id=#{id}")
    @Results(id = "collectMap", value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "user_id", property = "noteId"),
            @Result(column = "note_id", property = "noteId")
    })
    Collect getById(Integer id);

    @SelectProvider(type = CollectProvider.class, method = "getCollect")
    @ResultMap("collectMap")
    Collect getByConditions(@Param("collect")Collect collect);

    @Select("select * from collect where user_id=#{userId}")
    @ResultMap("collectMap")
    List<Collect> listByUserId(Integer userId);
}
