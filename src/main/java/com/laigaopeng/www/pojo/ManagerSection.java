package com.laigaopeng.www.pojo;

/**
 * 区域管理员和区域绑定类
 *
 */
public class ManagerSection {

    private Integer id;

    private Integer userId;

    private Integer sectionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    @Override
    public String toString() {
        return "ManagerSection{" +
                "id=" + id +
                ", userId=" + userId +
                ", sectionId=" + sectionId +
                '}';
    }
}
