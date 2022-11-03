package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.UserRole;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserRoleProvider extends SQL {

    public String deleteUserRole(@Param("userRole")UserRole userRole) {
        return new SQL() {{
            DELETE_FROM("user_role");

            if (!EmptyCheckerUtil.isIntegerEmpty(userRole.getRoleId())) {
                WHERE("role_id = #{userRole.roleId}");
            }
            if (!EmptyCheckerUtil.isIntegerEmpty(userRole.getUserId())) {
                WHERE("user_id = #{userRole.userId}");
            }
        }}.toString();
    }
}
