package com.laigaopeng.www.pojo;

/**
 * note_tag笔记-标签表实体类
 * 用于绑定笔记及其标签
 */
public class NoteTag {

    private Integer id;

    private Integer noteId;

    private Integer tagId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "NoteTag{" +
                "id=" + id +
                ", noteId=" + noteId +
                ", tagId=" + tagId +
                '}';
    }
}
