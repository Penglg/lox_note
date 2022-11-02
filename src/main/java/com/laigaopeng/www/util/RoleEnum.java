package com.laigaopeng.www.util;

/**
 * 角色枚举类
 *
 */
public enum RoleEnum {

    NORMAL_USER(0, "普通用户"),
    SECTION_MANAGER(1, "区域管理员"),
    SYSTEM_MANAGER(2, "系统管理员");


    private final Integer permissionLevel;
    private final String desc;

    RoleEnum(Integer permissionLevel, String desc) {
        this.permissionLevel = permissionLevel;
        this.desc = desc;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public String getDesc() {
        return desc;
    }
}
