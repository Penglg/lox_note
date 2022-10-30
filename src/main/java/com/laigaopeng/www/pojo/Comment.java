package com.laigaopeng.www.pojo;

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
    private LocalDateTime dateTime;

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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
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
