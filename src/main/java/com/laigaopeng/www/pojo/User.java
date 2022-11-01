package com.laigaopeng.www.pojo;

import java.sql.Date;
import java.util.List;

/**
 * 用户实体类
 */
public class User {

    private Integer id;

    private String name;

    // 用户账号
    private String account;

    private String password;

    private String sex;

    private String photo;

    private Integer disabled; // 用户是否被禁止发布笔记，默认为0，1为被禁止

    private Date createDate;

    /* 非数据库字段 */
    private List<Role> roles; // 用户的所有角色

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", sex='" + sex + '\'' +
                ", photo='" + photo + '\'' +
                ", disabled=" + disabled +
                ", createDate=" + createDate +
                '}';
    }
}
