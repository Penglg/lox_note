package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.Section;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class SectionProvider extends SQL {

    public String updateSection(@Param("section")Section section) {
        return new SQL() {{
            UPDATE("section");

            if (!EmptyCheckerUtil.isStringEmpty(section.getName())) {
                SET("name = #{section.name}");
            }
            if (!EmptyCheckerUtil.isStringEmpty(section.getDesc())) {
                SET("`desc` = #{section.desc}");
            }
            WHERE("id = #{section.id}");
        }}.toString();
    }
}
