package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.Role;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class RoleProvider extends SQL {

    public String updateRole(@Param("role")Role role) {
        return new SQL() {{
            UPDATE("role");

            if (!EmptyCheckerUtil.isStringEmpty(role.getName())) {
                SET("name = #{role.name}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(role.getPermissionLevel())) {
                SET("permission_level = #{role.permissionLevel}");
            }
            if (!EmptyCheckerUtil.isStringEmpty(role.getDesc())) {
                SET("`desc` = #{role.desc}");
            }
            WHERE("id = #{role.id}");
        }}.toString();
    }
}
