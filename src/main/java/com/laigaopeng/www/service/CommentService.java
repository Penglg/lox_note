package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 评论业务逻辑层
 *
 */
public interface CommentService {

    /**
     * 发布评论
     *
     * @param comment 评论
     * @return 发布结果
     */
    @Transactional
    boolean save(Comment comment);

    /**
     * 删除评论
     *
     * @param id 评论主键
     * @return 删除结果
     */
    @Transactional
    boolean delete(Integer id);

    /**
     * 获取笔记下所有评论
     *
     * @param noteId 笔记主键
     * @return 查找结果
     */
    List<Comment> listNoteComments(Integer noteId);

    /**
     * 删除笔记下所有评论
     *
     * @param noteId 笔记主键
     * @return 执行成功结果
     */
    @Transactional
    boolean deleteNoteComments(Integer noteId);
}
