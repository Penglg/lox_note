package com.laigaopeng.www.dao.provider;

import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 操作user表所需的sql语句拼接
 */
public class UserProvider extends SQL {

    public String updateUser(@Param("user") User user) {
        return new SQL(){{
            UPDATE("user");

            if (!EmptyCheckerUtil.isStringEmpty(user.getName())) {
                SET("name = #{user.name}");
            }
            if (!EmptyCheckerUtil.isStringEmpty(user.getPassword())) {
                SET("password = #{user.password}");
            }
            if (!EmptyCheckerUtil.isStringEmpty(user.getSex())) {
                SET("sex = #{user.sex}");
            }
            WHERE("id = #{user.id}");
        }}.toString();
    }
}
