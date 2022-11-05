package com.laigaopeng.www.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * comment评论实体类
 */
public class Comment {

    private Integer id;

    private Integer userId;

    private Integer noteId;

    // 评论内容
    private String content;

    // 评论时间
    private Timestamp dateTime;

    /* 非数据库表字段属性 */
    private Note note;

    private User user;

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", noteId=" + noteId +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
