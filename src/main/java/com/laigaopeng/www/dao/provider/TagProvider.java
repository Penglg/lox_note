package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.Tag;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class TagProvider extends SQL {

    public String updateTag(@Param("tag")Tag tag) {
        return new SQL() {{
            UPDATE("tag");

            if (!EmptyCheckerUtil.isStringEmpty(tag.getName())) {
                SET("name = #{tag.name}");
            }
            if (!EmptyCheckerUtil.isStringEmpty(tag.getDesc())) {
                SET("desc = #{tag.desc}");
            }
            WHERE("id = #{tag.id}");
        }}.toString();
    }
}
