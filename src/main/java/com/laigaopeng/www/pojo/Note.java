package com.laigaopeng.www.pojo;

import java.sql.Timestamp;
import java.util.List;

/**
 * note笔记实体类
 */
public class Note {

    private Integer id;

    private String title;

    private Integer userId;

    private String content; // 笔记内容

    private String photo;

    private Integer sectionId; // 笔记所在分区id

    private Integer likes; // 笔记获得点赞数，默认0

    private Integer collect; // 笔记获得收藏数，默认0

    private Timestamp dateTime; // 笔记发布时间

    private Integer legal; // 笔记是否被禁止

    /* 非数据库表字段属性 */
    private List<Tag> tags; // 笔记的标签

    private Section section; // 笔记所在分区

    private String approvalContent;  // 笔记申请说明

    public String getApprovalContent() {
        return approvalContent;
    }

    public void setApprovalContent(String approvalContent) {
        this.approvalContent = approvalContent;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Integer getLegal() {
        return legal;
    }

    public void setLegal(Integer legal) {
        this.legal = legal;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", photo='" + photo + '\'' +
                ", sectionId=" + sectionId +
                ", likes=" + likes +
                ", collect=" + collect +
                ", dateTime=" + dateTime +
                ", legal=" + legal +
                ", tags=" + tags +
                ", section=" + section +
                '}';
    }
}
