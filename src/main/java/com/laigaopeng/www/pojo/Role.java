package com.laigaopeng.www.pojo;

/**
 * role角色实体类
 */
public class Role {

    private Integer id;

    private String name;

    // 权限等级
    private Integer permissionLevel;

    // 角色描述
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permissionLevel=" + permissionLevel +
                ", desc='" + desc + '\'' +
                '}';
    }
}
