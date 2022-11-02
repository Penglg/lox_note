package com.laigaopeng.www.service;

public interface NoteTagService {

    /**
     * 新增笔记和标签的绑定
     *
     * @param noteId 笔记主键
     * @param tagId 标签主键
     * @return 执行结果
     */
    boolean save(Integer noteId, Integer tagId);

    /**
     * 删除笔记和标签的绑定
     *
     * @param id 绑定抓紧
     * @return 执行结果
     */
    boolean delete(Integer id);
}
