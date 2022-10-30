package com.laigaopeng.www.pojo;

/**
 * like点赞实体类
 * 用于绑定用户与其点赞的笔记
 */
public class Like {

    private Integer id;

    private Integer userId;

    private Integer noteId;

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

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", userId=" + userId +
                ", noteId=" + noteId +
                '}';
    }
}
