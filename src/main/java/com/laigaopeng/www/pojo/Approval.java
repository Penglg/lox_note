package com.laigaopeng.www.pojo;

/**
 * approval审批实体类
 */
public class Approval {

    private Integer id;

    private Integer noteId;

    private Integer userId;

    // 审批申请内容说明
    private String content;

    // 审批结果，1为审批通过，0为未通过
    private Integer result;

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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "id=" + id +
                ", noteId=" + noteId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", result=" + result +
                '}';
    }
}
