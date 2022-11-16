package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.NoteTag;
import org.springframework.transaction.annotation.Transactional;

public interface NoteTagService {

    /**
     * 新增笔记和标签的绑定
     *
     * @param noteTag 笔记和标签的绑定
     * @return 执行结果
     */
    @Transactional
    boolean save(NoteTag noteTag);

    /**
     * 删除笔记和标签的绑定
     *
     * @param id 绑定抓紧
     * @return 执行结果
     */
    @Transactional
    boolean delete(Integer id);

    /**
     * 删除笔记和标签的绑定
     *
     * @param noteId 笔记主键
     * @return 执行结果
     */
    @Transactional
    boolean deleteNoteTags(Integer noteId);
}
