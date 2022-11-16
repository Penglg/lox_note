package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.ManagerSection;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ManagerSectionProvider extends SQL {

    public String deleteManagerSection(@Param("ms")ManagerSection managerSection) {
        return new SQL(){{
            DELETE_FROM("manager_section");
            if (!EmptyCheckerUtil.isIntegerEmpty(managerSection.getSectionId())) {
                WHERE("id = #{ms.id}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(managerSection.getUserId())) {
                WHERE("user_id = #{ms.userId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(managerSection.getSectionId())) {
                WHERE("section_id = #{ms.sectionId}");
            }
        }}.toString();
    }
}
